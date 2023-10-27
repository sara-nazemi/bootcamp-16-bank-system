package org.bank.converter;

import org.bank.dto.TransactionDto;
import org.bank.dto.WithdrawDto;
import org.bank.models.TransactionEntity;
import org.bank.models.WithdrawEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WithdrawConvert extends BaseConverter<WithdrawEntity, WithdrawDto> {

    @Override
    @Mapping(source = "accountInfoId", target = "accountInfoEntity.id")
    @Mapping(source = "accountInfoVersion", target = "accountInfoEntity.version")
    WithdrawEntity convertEntity(WithdrawDto model);

    @Override
    @Mapping(source = "accountInfoEntity.id", target = "accountInfoId")
    @Mapping(source = "accountInfoEntity.version", target = "accountInfoVersion")
    WithdrawDto convertDto(WithdrawEntity model);
}
