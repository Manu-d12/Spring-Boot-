package com.spring_concepts.Controllers;

import com.spring_concepts.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private TransactionService transactionService;
    public static List<String> users;

    static {
        users =   new ArrayList<>();
        users.add("Manoj");
        users.add("Ram");
        users.add("Hanuman");
        users.add("Diksha");
        users.add("Kamal");
    }



    @GetMapping("/{id}")
    public String getUserById(
            @PathVariable String id
    ) {
        int idIdx = Integer.parseInt(id);
        this.transactionService.fetchUserById(idIdx);
        return  idIdx >= users.size() ? "USER_NOT_FOUND" :  UserController.users.get(idIdx);
    }

    @GetMapping
    public List<String> getAllUsers_ExceptionResolver(){
        return users;
    }
}
