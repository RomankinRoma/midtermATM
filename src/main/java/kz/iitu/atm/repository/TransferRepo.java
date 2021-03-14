package kz.iitu.atm.repository;

import kz.iitu.atm.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepo extends JpaRepository<Transfer,Integer> {
    Transfer getById(Integer id);
    List<Transfer> getAllBySenderId(Integer id);
    List<Transfer> getAllByReceiverId(Integer id);
    List<Transfer> getAllByReceiverIdAndSenderId(Integer receiver,Integer sender);
}
