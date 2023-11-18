package ir.bootcamp.java.banksystem.sftp.converter;

import ir.bootcamp.java.banksystem.models.documents.dto.AccountInfoDto;
import ir.bootcamp.java.banksystem.models.documents.models.AccountInfoEntity;
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
