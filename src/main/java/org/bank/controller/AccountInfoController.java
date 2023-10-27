package org.bank.controller;

import org.bank.dto.AccountInfoDto;
import org.bank.models.AccountInfoEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/accountInfo")
public class AccountInfoController extends BaseController<AccountInfoEntity, AccountInfoDto, Long> {

}
