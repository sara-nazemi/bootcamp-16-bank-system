package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.dto.CardToCardTransactionDto;
import ir.bootcamp.java.banksystem.models.documents.models.CardInfoEntity;
import ir.bootcamp.java.banksystem.models.documents.models.CardToCardEntity;
import ir.bootcamp.java.banksystem.sftp.exception.BankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
public class CardToCardServiceImpl extends BaseServiceImpl<CardToCardEntity, Long> implements CardToCardService {

    @Autowired
    CardInfoService cardInfoService;
    @Autowired
    AccountInfoService accountInfoService;
    @Autowired
    WithdrawService withdrawService;
    @Autowired
    DepositService depositService;


    @Override
    @Transactional
    public Boolean cardToCard(CardToCardTransactionDto dto) {
        if (dto.getSourceCardNumber() == null || dto.getTargetCardNumber() == null || dto.getAmount() == null) {
            throw new BankException("transaction.cannot.edit");
        }

        CardInfoEntity sourceCardInfo = cardInfoService.findByCardNumber(dto.getSourceCardNumber());
        CardInfoEntity targetCardInfo = cardInfoService.findByCardNumber(dto.getTargetCardNumber());
        Integer rnd = new Random().nextInt(999999);


        // save increase
        CardToCardEntity increase = new CardToCardEntity();
        increase.setCardInfoSource(sourceCardInfo);
        increase.setCardInfoTarget(targetCardInfo);

        increase.setDateTransaction(new Date());
        increase.setTracking(String.valueOf(rnd));
        increase.setAccountInfoEntity(targetCardInfo.getAccountInfoEntity());
        increase.setAmount(dto.getAmount());

        save(increase);

        // save decrease
        CardToCardEntity decrease = new CardToCardEntity();
        decrease.setCardInfoSource(sourceCardInfo);
        decrease.setCardInfoTarget(targetCardInfo);

        decrease.setTracking(String.valueOf(rnd));
        decrease.setAccountInfoEntity(sourceCardInfo.getAccountInfoEntity());
        decrease.setAmount(dto.getAmount() * -1);

        save(decrease);

        return true;
    }
}
