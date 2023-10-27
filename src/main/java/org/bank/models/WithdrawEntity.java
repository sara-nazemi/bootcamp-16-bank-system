package org.bank.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Withdraw")
public class WithdrawEntity extends TransactionEntity {
}
