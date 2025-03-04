package booklib.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import booklib.data.ClientRepository;
import booklib.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/current")
    public ResponseEntity<Client> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Client client = clientRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found")); 
        return ResponseEntity.ok(client);
    }

}
