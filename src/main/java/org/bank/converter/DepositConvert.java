package org.bank.converter;

import org.bank.dto.DepositDto;
import org.bank.models.DepositEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepositConvert extends BaseConverter<DepositEntity, DepositDto> {

    @Override
    @Mapping(source = "accountInfoId", target = "accountInfoEntity.id")
    @Mapping(source = "accountInfoVersion", target = "accountInfoEntity.version")
    DepositEntity convertEntity(DepositDto model);

    @Override
    @Mapping(source = "accountInfoEntity.id", target = "accountInfoId")
    @Mapping(source = "accountInfoEntity.version", target = "accountInfoVersion")
    DepositDto convertDto(DepositEntity model);
}
