package kz.iitu.atm.controller;

import kz.iitu.atm.model.User;
import kz.iitu.atm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public User getInfo(@PathVariable Integer id){
        return iUserService.getById(id);
    }

    @RequestMapping(value = "/get/username",method = RequestMethod.GET)
    public User getInfo(@RequestParam String username){
        return iUserService.getByUsername(username);
    }
    @RequestMapping(value = "/get/phone",method = RequestMethod.GET)
    public User get(@RequestParam String phone){
        return iUserService.getByPhoneNumber(phone);
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return iUserService.create(user);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return iUserService.update(user);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        iUserService.delete(id);
    }


}
