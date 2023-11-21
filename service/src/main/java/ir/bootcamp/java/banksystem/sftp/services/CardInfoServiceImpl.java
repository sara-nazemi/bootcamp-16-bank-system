package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.CardInfoEntity;
import ir.bootcamp.java.banksystem.sftp.repositories.CardInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardInfoServiceImpl extends BaseServiceImpl<CardInfoEntity, Long> implements CardInfoService {

    @Autowired
    CardInfoRepository cardInfoRepository;

    @Override
    public CardInfoEntity findByCardNumber(String cardNumber) {
        return cardInfoRepository.findByCardNumber(cardNumber);
    }

}
