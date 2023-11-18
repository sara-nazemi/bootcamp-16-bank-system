package ir.bootcamp.java.banksystem.sftp.converter;

import ir.bootcamp.java.banksystem.models.documents.dto.PersonDto;
import ir.bootcamp.java.banksystem.models.documents.models.PersonEntity;
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
