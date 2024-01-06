package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
import ir.bootcamp.java.banksystem.models.documents.models.DepositEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServiceImpl extends BaseServiceImpl<DepositEntity, Long> implements DepositService {

    private final AccountInfoService accountInfoService;

    @Autowired
    public DepositServiceImpl(AccountInfoService accountInfoService) {
        this.accountInfoService = accountInfoService;
    }

    @Override
    public DepositEntity save(DepositEntity entity) {
        AccountInfoEntity accountInfo = accountInfoService.createAccountInfo(entity);
        double sumInventory = entity.getAmount() + accountInfo.getInventory();
        accountInfo.setInventory(sumInventory);
        accountInfoService.save(accountInfo);

        entity.setAccountInfoEntity(accountInfo);

        return super.save(entity);
    }
}
