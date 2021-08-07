package authentication.auth.domain;


import lombok.Data;

import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Data
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    @ElementCollection
    private List<String> roles= new ArrayList<>();


}