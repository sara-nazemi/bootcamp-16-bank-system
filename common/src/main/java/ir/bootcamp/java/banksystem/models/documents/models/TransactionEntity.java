package ir.bootcamp.java.banksystem.models.documents.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_transaction")
public class TransactionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_datetransaction")
    private Date dateTransaction;

    @Column(name = "t_amount")
    private Double amount;

    @Column(name = "t_tracking", unique = true)
    private String tracking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_accountinfo", nullable = false)
    private AccountInfoEntity accountInfoEntity;
}
