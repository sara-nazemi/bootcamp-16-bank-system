package ir.bootcamp.java.banksystem.sftp.controllers;

import ir.bootcamp.java.banksystem.models.documents.dto.CardInfoDto;
import ir.bootcamp.java.banksystem.models.documents.models.CardInfoEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cardInfo")
public class CardInfoController extends BaseController<CardInfoEntity, CardInfoDto, Long> {

}
