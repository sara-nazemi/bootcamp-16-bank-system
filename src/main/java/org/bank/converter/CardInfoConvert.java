package org.bank.converter;

import org.bank.dto.CardInfoDto;
import org.bank.models.CardInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardInfoConvert extends BaseConverter<CardInfoEntity, CardInfoDto> {

    @Override
    @Mapping(source = "accountInfoId", target = "accountInfoEntity.id")
    @Mapping(source = "accountInfoVersion", target = "accountInfoEntity.version")
    CardInfoEntity convertEntity(CardInfoDto model);

    @Override
    @Mapping(source = "accountInfoEntity.id", target = "accountInfoId")
    @Mapping(source = "accountInfoEntity.version", target = "accountInfoVersion")
    CardInfoDto convertDto(CardInfoEntity model);
}
