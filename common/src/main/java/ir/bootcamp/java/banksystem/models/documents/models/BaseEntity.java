package ir.bootcamp.java.banksystem.models.documents.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
//@DynamicInsert
//@DynamicUpdate
/*@EntityListeners(AuditingEntityListener.class)*/
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1234567L;

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
