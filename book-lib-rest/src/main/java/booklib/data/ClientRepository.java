package booklib.data;

import org.springframework.data.repository.CrudRepository;

import booklib.model.Client;

public interface ClientRepository
        extends CrudRepository<Client, Long> {
}
