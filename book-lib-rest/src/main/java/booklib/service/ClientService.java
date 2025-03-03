package booklib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import booklib.data.ClientRepository;
import booklib.model.Client;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createClient(String username, String password, String email, String role) {
        
        Client client = new Client();
        client.setUsername(username);
        client.setPassword(passwordEncoder.encode(password));
        client.setEmail(email);
        client.setRole(role);
        clientRepository.save(client);
    }

}
