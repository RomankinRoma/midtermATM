package kz.iitu.atm.repository;

import kz.iitu.atm.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
    Transaction getById(Integer id);
    List<Transaction> getAllByUserId(Integer id);

}
