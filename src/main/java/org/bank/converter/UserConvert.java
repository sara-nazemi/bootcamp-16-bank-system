package org.bank.converter;

import org.bank.dto.UserDto;
import org.bank.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserConvert extends BaseConverter<UserEntity, UserDto> {

    @Override
    @Mapping(source = "personEntity.id", target = "personId")
    @Mapping(source = "personEntity.name", target = "personName")
    @Mapping(source = "personEntity.family", target = "personFamily")
    UserDto convertDto(UserEntity model);

    @Override
    @Mapping(source = "personId", target = "personEntity.id")
    UserEntity convertEntity(UserDto model);

}
