package booklib.model;

import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Transactional
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull
    @Column(unique = true)
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String username;

    @NotNull
    private String password;
    
    @NotNull
    private String role = "ROLE_CLIENT";

    @NotNull
    @Email
    private String email;

}
