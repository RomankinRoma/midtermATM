package kz.iitu.atm.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private Long balance;
}
