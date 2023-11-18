package ir.bootcamp.java.banksystem.models.documents.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_cardinfo")
public class CardInfoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private Long id;

    @Column(name = "c_cardnumber", unique = true)
    private String cardNumber;

    @Column(name = "c_expireyear")
    private String expireYear;

    @Column(name = "c_expiremonth")
    private String expireMonth;

    @Column(name = "c_cvv2", unique = true)
    private String cvv2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_accountinfo", nullable = false)
    private AccountInfoEntity accountInfoEntity;
}
