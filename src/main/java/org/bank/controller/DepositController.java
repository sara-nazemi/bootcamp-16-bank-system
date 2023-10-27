package org.bank.controller;

import org.bank.dto.DepositDto;
import org.bank.dto.TransactionDto;
import org.bank.models.DepositEntity;
import org.bank.models.TransactionEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/deposit")
public class DepositController extends BaseController<DepositEntity, DepositDto, Long> {

}
