package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
import ir.bootcamp.java.banksystem.models.documents.models.TransactionEntity;
import ir.bootcamp.java.banksystem.sftp.exception.BankException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service

public class AccountInfoServiceImpl extends BaseServiceImpl<AccountInfoEntity, Long> implements AccountInfoService {


    @Override
    public <E extends TransactionEntity> AccountInfoEntity createAccountInfo(E entity) {
        if (entity.getId() != null) {
            throw new BankException("transaction.cannot.edit");
        }
        entity.setDateTransaction(new Date());
        Integer rnd = new Random().nextInt(999999);
        entity.setTracking(String.valueOf(rnd));

        return findById(entity.getAccountInfoEntity().getId());

    }
}
