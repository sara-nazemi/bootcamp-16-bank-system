package ir.bootcamp.java.banksystem.models.documents.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Withdraw")
public class WithdrawEntity extends TransactionEntity {
}
