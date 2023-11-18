package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.CardInfoEntity;

public interface CardInfoService extends BaseService<CardInfoEntity, Long> {
    CardInfoEntity findByCardNumber(String cardNumber);
}
