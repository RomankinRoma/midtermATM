package kz.iitu.atm.service.impl;

import kz.iitu.atm.model.Transfer;
import kz.iitu.atm.model.User;
import kz.iitu.atm.repository.TransferRepo;
import kz.iitu.atm.repository.UserRepo;
import kz.iitu.atm.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements ITransferService {

    @Autowired
    private TransferRepo transferRepo;

    @Autowired
    private UserRepo userRepo;


    @Override
    public Transfer create(Transfer object) {
        User sender = userRepo.getById(object.getSenderId());
        User receiver = userRepo.getById(object.getReceiverId());
        if (sender.getBalance()>object.getAmount()){
            sender.setBalance(sender.getBalance()-object.getAmount());
            receiver.setBalance(receiver.getBalance()+object.getAmount());
            userRepo.save(receiver);
            userRepo.save(sender);
        return transferRepo.save(object);
        }
        return null;
    }

    @Override
    public Transfer update(Transfer object) {
        return transferRepo.save(object);
    }

    @Override
    public void delete(Integer id) {
        transferRepo.delete(transferRepo.getById(id));
    }

    @Override
    public List<Transfer> getAll() {
        return transferRepo.findAll();
    }

    @Override
    public Transfer getTransfer(Integer id) {
        return transferRepo.getById(id);
    }

    @Override
    public List<Transfer> getAllBySender(Integer id) {
        return transferRepo.getAllBySenderId(id);
    }

    @Override
    public List<Transfer> getAllByReceiver(Integer id) {
        return transferRepo.getAllByReceiverId(id);
    }

    @Override
    public List<Transfer> getAllBySenderAndReceiver(Integer sender, Integer receiver) {
        return transferRepo.getAllByReceiverIdAndSenderId(receiver,sender);
    }
}
