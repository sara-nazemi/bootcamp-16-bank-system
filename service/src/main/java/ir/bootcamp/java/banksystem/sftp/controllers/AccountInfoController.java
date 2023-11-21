package ir.bootcamp.java.banksystem.sftp.controllers;

import ir.bootcamp.java.banksystem.models.documents.dto.AccountInfoDto;
import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accountInfo")
public class AccountInfoController extends BaseController<AccountInfoEntity, AccountInfoDto, Long> {

}
