package org.bank.services;

import org.bank.models.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonEntity, Long> implements PersonService {

}
