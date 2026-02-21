package com.spring_concepts.Controllers;

import com.spring_concepts.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public static List<String> users;

    static {
        users =   new ArrayList<>();
        users.add("Manoj");
        users.add("Ram");
        users.add("Hanuman");
        users.add("Diksha");
        users.add("Kamal");
    }


    @Autowired
    private TransactionService transactionService;


    @GetMapping("/{id}")
    public String getUserById(
            @PathVariable String id
    ) {
        int idIdx = Integer.parseInt(id);
        this.transactionService.fetchUserById(idIdx);
        return  idIdx >= users.size() ? "USER_NOT_FOUND" :  UserController.users.get(idIdx);
    }
}
