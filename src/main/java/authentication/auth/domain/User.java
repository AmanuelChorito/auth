package authentication.auth.domain;


import lombok.Data;

import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private boolean active;


    @Enumerated(EnumType.STRING)
    private Role roles;



}