package org.bank.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Deposit")
public class DepositEntity extends TransactionEntity {
}
