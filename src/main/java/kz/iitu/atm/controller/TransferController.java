package kz.iitu.atm.controller;

import kz.iitu.atm.model.Transfer;
import kz.iitu.atm.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transfer")
public class TransferController {

    @Autowired
    private ITransferService iTransferService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Transfer create(@RequestBody Transfer transfer){
        return iTransferService.create(transfer);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Transfer update(@RequestBody Transfer transfer){
        return iTransferService.update(transfer);
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        iTransferService.delete(id);
    }
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Transfer get(@PathVariable Integer id){
        return iTransferService.getTransfer(id);
    }
    @RequestMapping(value = "/get/sender/{id}",method = RequestMethod.GET)
    public List<Transfer> getBySender(@PathVariable Integer id){
        return  iTransferService.getAllBySender(id);
    }
    @RequestMapping(value = "/get/receiver/{id}",method = RequestMethod.GET)
    public List<Transfer> getByReceiver(@PathVariable Integer id){
        return  iTransferService.getAllByReceiver(id);
    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Transfer> getBySenderAndReceiver(@Param(value = "sender") Integer sender,@Param(value = "receiver") Integer receiver){
        return  iTransferService.getAllBySenderAndReceiver(sender,receiver);
    }
}
