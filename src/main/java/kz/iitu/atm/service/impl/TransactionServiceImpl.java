package kz.iitu.atm.service.impl;

import kz.iitu.atm.model.Transaction;
import kz.iitu.atm.model.User;
import kz.iitu.atm.repository.TransactionRepo;
import kz.iitu.atm.repository.UserRepo;
import kz.iitu.atm.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Transaction create(Transaction object) {
        User user = userRepo.getById(object.getUserId());
        if (user.getBalance()>object.getAmount()){
            user.setBalance(user.getBalance()-object.getAmount());
            userRepo.save(user);
            return transactionRepo.save(object);
        }
        return null;
    }

    @Override
    public Transaction update(Transaction object) {
        return transactionRepo.save(object);
    }

    @Override
    public void delete(Integer id) {
        transactionRepo.delete(transactionRepo.getById(id));
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    @Override
    public Transaction getById(Integer id) {
        return transactionRepo.getById(id);
    }

    @Override
    public List<Transaction> getAllByUserId(Integer id) {
        return transactionRepo.getAllByUserId(id);
    }
}
