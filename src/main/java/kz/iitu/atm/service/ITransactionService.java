package kz.iitu.atm.service;

import kz.iitu.atm.model.Transaction;

import java.util.List;

public interface ITransactionService {
    Transaction create(Transaction object);
    Transaction update(Transaction object);
    void delete(Integer id);
    List<Transaction> getAll();
    Transaction getById(Integer id);
    List<Transaction> getAllByUserId(Integer id);
}
