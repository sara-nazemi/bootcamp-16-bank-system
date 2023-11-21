package ir.bootcamp.java.banksystem.sftp.controllers;

import ir.bootcamp.java.banksystem.models.documents.dto.PersonDto;
import ir.bootcamp.java.banksystem.models.documents.models.PersonEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<PersonEntity, PersonDto, Long> {

}
