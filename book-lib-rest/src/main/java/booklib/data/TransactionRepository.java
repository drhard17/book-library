package booklib.data;

import org.springframework.data.repository.CrudRepository;

import booklib.model.Transaction;

public interface TransactionRepository
        extends CrudRepository<Transaction, Long> {
}
