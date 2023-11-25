package ir.bootcamp.java.banksystem.sftp.converter;

import ir.bootcamp.java.banksystem.models.documents.dto.CardToCardDto;
import ir.bootcamp.java.banksystem.models.documents.models.CardToCardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardToCardConverter extends BaseConverter<CardToCardEntity, CardToCardDto> {

    @Override
    /*@Mapping(source = "accountInfoId", target = "accountInfoEntity.id")
    @Mapping(source = "cardInfoTarget", target = "cardInfoTarget")
    @Mapping(source = "cardInfoSource", target = "cardInfoSource")
    @Mapping(source = "dateTransaction", target = "dateTransaction")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "accountInfoVersion", target = "accountInfoEntity.version")*/
    CardToCardEntity convertEntity(CardToCardDto model);

    @Override
    /*@Mapping(source = "accountInfoEntity.id", target = "accountInfoId")
    @Mapping(source = "cardInfoTarget", target = "cardInfoTarget")
    @Mapping(source = "cardInfoSource", target = "cardInfoSource")
    @Mapping(source = "dateTransaction", target = "dateTransaction")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "accountInfoEntity.version", target = "accountInfoVersion")*/
    CardToCardDto convertDto(CardToCardEntity model);
}
