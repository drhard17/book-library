package booklib.data;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import booklib.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findByUsername(String username);                
}
