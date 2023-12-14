package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
import ir.bootcamp.java.banksystem.models.documents.models.DepositEntity;
import ir.bootcamp.java.banksystem.sftp.exception.BankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class DepositServiceImpl extends BaseServiceImpl<DepositEntity, Long> implements DepositService {

    private final AccountInfoService accountInfoService;

    @Autowired
    public DepositServiceImpl(AccountInfoService accountInfoService) {
        this.accountInfoService = accountInfoService;
    }

    @Override
    public DepositEntity save(DepositEntity entity) {
        if (entity.getId() != null) {
            throw new BankException("transaction.cannot.edit");
        }
        entity.setDateTransaction(new Date());
        Integer rnd = new Random().nextInt(999999);
        entity.setTracking(String.valueOf(rnd));

        AccountInfoEntity accountInfo = accountInfoService.findById(entity.getAccountInfoEntity().getId());
        double sumInventory = entity.getAmount() + accountInfo.getInventory();
        accountInfo.setInventory(sumInventory);
        accountInfoService.save(accountInfo);

        entity.setAccountInfoEntity(accountInfo);

        return super.save(entity);
    }
}
