package org.bank.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private Date insertDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Version
    private Integer version;

    @PrePersist
    protected void onCreate() {
        this.insertDate = this.lastModifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = new Date();
    }

}
