package org.bank.controller;

import org.bank.dto.CardInfoDto;
import org.bank.models.CardInfoEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cardInfo")
public class CardInfoController extends BaseController<CardInfoEntity, CardInfoDto, Long> {

}
