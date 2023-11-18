package ir.bootcamp.java.banksystem.sftp.controller;

import ir.bootcamp.java.banksystem.models.documents.dto.CardToCardDto;
import ir.bootcamp.java.banksystem.models.documents.dto.CardToCardTransactionDto;
import ir.bootcamp.java.banksystem.models.documents.models.CardToCardEntity;
import ir.bootcamp.java.banksystem.sftp.controller.response.BankResponse;
import ir.bootcamp.java.banksystem.sftp.services.CardToCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/cardtocard")
public class CardToCardController extends BaseController<CardToCardEntity, CardToCardDto, Long> {

    @Autowired
    CardToCardService cardToCardService;


    @PostMapping("/do")
    public BankResponse cardToCard(@RequestBody CardToCardTransactionDto dto) {
        Boolean result = cardToCardService.cardToCard(dto);
        return null;
    }
}
