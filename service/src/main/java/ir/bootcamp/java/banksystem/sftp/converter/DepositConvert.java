package ir.bootcamp.java.banksystem.sftp.converter;

import ir.bootcamp.java.banksystem.models.documents.dto.DepositDto;
import ir.bootcamp.java.banksystem.models.documents.models.DepositEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepositConvert extends BaseConverter<DepositEntity, DepositDto> {

    @Override
    @Mapping(source = "accountInfoId", target = "accountInfoEntity.id")
    @Mapping(source = "dateTransaction", target = "dateTransaction")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "accountInfoVersion", target = "accountInfoEntity.version")
    @Mapping(source = "id", target = "id")
    DepositEntity convertEntity(DepositDto model);

    @Override
    @Mapping(source = "accountInfoEntity.id", target = "accountInfoId")
    @Mapping(source = "dateTransaction", target = "dateTransaction")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountInfoEntity.version", target = "accountInfoVersion")
    DepositDto convertDto(DepositEntity model);
}
