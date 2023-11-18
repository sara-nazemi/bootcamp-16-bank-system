package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
import ir.bootcamp.java.banksystem.models.documents.models.WithdrawEntity;
import ir.bootcamp.java.banksystem.sftp.exception.BankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class WithdrawServiceImpl extends BaseServiceImpl<WithdrawEntity, Long> implements WithdrawService {

    @Autowired
    private AccountInfoService accountInfoService;

    @Override
    public WithdrawEntity save(WithdrawEntity entity) {


        if (entity.getId() != null) {
            throw new BankException("transaction.cannot.edit");
        }
        entity.setDateTransaction(new Date());
        Integer rnd = new Random().nextInt(999999);
        entity.setTracking(String.valueOf(rnd));

        AccountInfoEntity accountInfo = accountInfoService.findById(entity.getAccountInfoEntity().getId());

        Double inventory = accountInfo.getInventory();
        double result = inventory - entity.getAmount();

        if (result <= 5000) {
            throw new BankException("inventory.is.not.enough");
        }

        accountInfo.setInventory(result);
        accountInfoService.save(accountInfo);

        entity.setAmount(entity.getAmount() * -1); // negative
        entity.setAccountInfoEntity(accountInfo); //fk

        return super.save(entity);
    }
}
