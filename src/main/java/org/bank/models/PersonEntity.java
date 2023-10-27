package org.bank.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "t_person")
public class PersonEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_familye")
    private String family;

    @Column(name = "p_nationalcode", unique = true)
    private String nationalCode;

    @Column(name = "p_address")
    private String address;

    @OneToOne
    @JoinColumn(name = "p_user_entity", nullable = false)
    private UserEntity userEntity;

}
