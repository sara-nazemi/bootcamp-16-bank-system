package org.bank.controller;

import org.bank.dto.DepositDto;
import org.bank.dto.WithdrawDto;
import org.bank.models.DepositEntity;
import org.bank.models.WithdrawEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/withdraw")
public class WithdrawController extends BaseController<WithdrawEntity, WithdrawDto, Long> {

}
