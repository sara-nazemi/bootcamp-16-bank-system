package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
import ir.bootcamp.java.banksystem.models.documents.models.TransactionEntity;

public interface AccountInfoService extends BaseService<AccountInfoEntity, Long> {

    <E extends TransactionEntity> AccountInfoEntity createAccountInfo(E entity);
}
