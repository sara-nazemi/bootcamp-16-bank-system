package org.bank.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_accountinfo")
public class AccountInfoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_id")
    private Long id;

    @Column(name = "a_number", length = 10, unique = true)
    private String number;

    @Column(name = "a_iban", unique = true)
    private String Iban;

    @Column(name = "a_inventory")
    private Double inventory;

    @Column(name = "a_accountnumber", unique = true)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_user", nullable = false)
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountInfoEntity", cascade = CascadeType.MERGE)
    private List<CardInfoEntity> cards;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountInfoEntity", cascade = CascadeType.MERGE)
    private List<TransactionEntity> transactions;

}
