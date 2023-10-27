package org.bank.converter;

import org.bank.dto.PersonDto;
import org.bank.models.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonConvert extends BaseConverter<PersonEntity, PersonDto> {

    @Override
    @Mapping(source = "userId", target = "userEntity.id")
    @Mapping(source = "userVersion", target = "userEntity.version")
    PersonEntity convertEntity(PersonDto model);

    @Override
    @Mapping(source = "userEntity.id", target = "userId")
    @Mapping(source = "userEntity.version", target = "userVersion")
    PersonDto convertDto(PersonEntity model);
}
