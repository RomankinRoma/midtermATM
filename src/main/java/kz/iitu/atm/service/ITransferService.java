package kz.iitu.atm.service;

import kz.iitu.atm.model.Transfer;

import java.util.List;

public interface ITransferService {
    Transfer create(Transfer object);
    Transfer update(Transfer object);
    void delete(Integer id);
    List<Transfer> getAll();
    Transfer getTransfer(Integer id);
    List<Transfer> getAllBySender(Integer id);
    List<Transfer> getAllByReceiver(Integer id);
    List<Transfer> getAllBySenderAndReceiver(Integer sender,Integer receiver);
}
