package ir.bootcamp.java.banksystem.sftp.controllers;

import ir.bootcamp.java.banksystem.models.documents.dto.WithdrawDto;
import ir.bootcamp.java.banksystem.models.documents.models.WithdrawEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/withdraw")
public class WithdrawController extends BaseController<WithdrawEntity, WithdrawDto, Long> {

}
