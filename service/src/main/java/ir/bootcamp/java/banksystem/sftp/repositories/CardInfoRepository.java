package ir.bootcamp.java.banksystem.sftp.repositories;

import ir.bootcamp.java.banksystem.models.documents.models.CardInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardInfoRepository extends BaseRepository<CardInfoEntity, Long> {
    @Query("select e from CardInfoEntity e where e.cardNumber=:number")
    CardInfoEntity findByCardNumber(@Param("number") String cardNumber);
}
