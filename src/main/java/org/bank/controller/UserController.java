package org.bank.controller;

import org.bank.dto.UserDto;
import org.bank.models.UserEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserEntity, UserDto, Long> {

}
