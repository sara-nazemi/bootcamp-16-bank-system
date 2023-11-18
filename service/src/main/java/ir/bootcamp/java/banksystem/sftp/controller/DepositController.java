package ir.bootcamp.java.banksystem.sftp.controller;

import ir.bootcamp.java.banksystem.models.documents.dto.DepositDto;
import ir.bootcamp.java.banksystem.models.documents.models.DepositEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/deposit")
public class DepositController extends BaseController<DepositEntity, DepositDto, Long> {

}
