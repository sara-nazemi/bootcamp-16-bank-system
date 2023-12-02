package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.CardInfoEntity;
import ir.bootcamp.java.banksystem.sftp.repositories.CardInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardInfoServiceImpl extends BaseServiceImpl<CardInfoEntity, Long> implements CardInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardInfoServiceImpl.class);

    @Autowired
    CardInfoRepository cardInfoRepository;

    @Override
    public CardInfoEntity findByCardNumber(String cardNumber) {
        LOGGER.info("find by card number most be call with : "+cardNumber);
        CardInfoEntity byCardNumber = cardInfoRepository.findByCardNumber(cardNumber);
        LOGGER.info("find by card number is called and data is : "+byCardNumber);
        return byCardNumber;
    }

}
