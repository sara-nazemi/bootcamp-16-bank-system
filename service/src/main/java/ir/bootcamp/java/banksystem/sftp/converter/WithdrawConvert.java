package ir.bootcamp.java.banksystem.sftp.converter;

import ir.bootcamp.java.banksystem.models.documents.dto.WithdrawDto;
import ir.bootcamp.java.banksystem.models.documents.models.WithdrawEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WithdrawConvert extends BaseConverter<WithdrawEntity, WithdrawDto> {

    @Override
    @Mapping(source = "accountInfoId", target = "accountInfoEntity.id")
    @Mapping(source = "dateTransaction", target = "dateTransaction")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "accountInfoVersion", target = "accountInfoEntity.version")
    WithdrawEntity convertEntity(WithdrawDto model);

    @Override
    @Mapping(source = "accountInfoEntity.id", target = "accountInfoId")
    @Mapping(source = "dateTransaction", target = "dateTransaction")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "accountInfoEntity.version", target = "accountInfoVersion")
    WithdrawDto convertDto(WithdrawEntity model);
}
