package org.bank.services;

import org.bank.models.AccountInfoEntity;
import org.bank.models.DepositEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class DepositServiceImpl extends BaseServiceImpl<DepositEntity, Long> implements DepositService {

    @Autowired
    private AccountInfoService accountInfoService;

    @Override
    public DepositEntity save(DepositEntity entity) {
        if (entity.getId() == null) {//save
            entity.setDateTransaction(new Date());
            Integer rnd = new Random().nextInt(999999);
            entity.setTracking(String.valueOf(rnd));

            AccountInfoEntity accountInfo = accountInfoService.findById(entity.getAccountInfoEntity().getId());
            double sumInventory = entity.getAmount() + accountInfo.getInventory();
            accountInfo.setInventory(sumInventory);
            accountInfoService.save(accountInfo);

            entity.setAccountInfoEntity(accountInfo);
        }
        return super.save(entity);
    }
}
