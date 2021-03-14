package kz.iitu.atm.controller;

import kz.iitu.atm.model.Transaction;
import kz.iitu.atm.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService iTransactionService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Transaction create(@RequestBody Transaction transaction){
        return iTransactionService.create(transaction);
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Transaction update(@RequestBody Transaction transaction){
        return iTransactionService.update(transaction);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        iTransactionService.delete(id);
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Transaction getById(@PathVariable Integer id){
        return iTransactionService.getById(id);
    }
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Transaction> getAll(){
        return iTransactionService.getAll();
    }
    @RequestMapping(value = "/get/user/{id}",method = RequestMethod.GET)
    public List<Transaction> getByUser(@PathVariable Integer id){
        return iTransactionService.getAllByUserId(id);
    }
}
