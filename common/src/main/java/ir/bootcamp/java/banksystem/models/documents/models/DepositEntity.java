package ir.bootcamp.java.banksystem.models.documents.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Deposit")
public class DepositEntity extends TransactionEntity {
}
