package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.dto.CardToCardTransactionDto;
import ir.bootcamp.java.banksystem.models.documents.models.CardToCardEntity;

public interface CardToCardService extends BaseService<CardToCardEntity, Long> {
    Boolean cardToCard(CardToCardTransactionDto dto);
}
