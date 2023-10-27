package org.bank.converter;

import org.bank.dto.AccountInfoDto;
import org.bank.models.AccountInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountInfoConvert extends BaseConverter<AccountInfoEntity, AccountInfoDto> {

    @Override
    @Mapping(source = "userId", target = "userEntity.id")
    @Mapping(source = "userVersion", target = "userEntity.version")
    AccountInfoEntity convertEntity(AccountInfoDto model);

    @Override
    @Mapping(source = "userEntity.id", target = "userId")
    @Mapping(source = "userEntity.version", target = "userVersion")
    AccountInfoDto convertDto(AccountInfoEntity model);
}
