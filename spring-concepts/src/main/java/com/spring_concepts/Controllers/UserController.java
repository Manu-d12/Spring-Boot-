package com.spring_concepts.Controllers;

import com.spring_concepts.Dao.UserDao;
import com.spring_concepts.dto.UserDto;
import com.spring_concepts.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private TransactionService transactionService;
    public static List<String> users;
    private final UserDao userDao;

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

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws Exception{
        userDao.insertUser(userDto);
        return ResponseEntity.ok(userDto);
    }
}
