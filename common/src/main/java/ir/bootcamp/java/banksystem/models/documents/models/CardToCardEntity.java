package ir.bootcamp.java.banksystem.models.documents.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("CardToCard")
@NoArgsConstructor
@AllArgsConstructor
public class CardToCardEntity extends TransactionEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_cardinfosource")
    private CardInfoEntity cardInfoSource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_cardinfotarget")
    private CardInfoEntity cardInfoTarget;

}
