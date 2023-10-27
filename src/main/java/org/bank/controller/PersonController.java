package org.bank.controller;

import org.bank.dto.PersonDto;
import org.bank.models.PersonEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<PersonEntity, PersonDto, Long> {

}
