package ir.bootcamp.java.banksystem.sftp.controller;

import ir.bootcamp.java.banksystem.models.documents.dto.UserDto;
import ir.bootcamp.java.banksystem.models.documents.models.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserEntity, UserDto, Long> {

}
