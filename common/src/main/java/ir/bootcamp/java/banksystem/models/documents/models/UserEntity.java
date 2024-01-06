package ir.bootcamp.java.banksystem.models.documents.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "t_user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_id")
    private Long id;

    @Column(name = "u_emaild")
    private String email;

    @Column(name = "u_telephone")
    private String telephone;

    @Column(name = "u_user_name", unique = true)
    private String username;

    @Column(name = "u_password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private PersonEntity personEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.MERGE)
    private List<AccountInfoEntity> accounts;
}
