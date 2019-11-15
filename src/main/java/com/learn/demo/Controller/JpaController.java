package com.learn.demo.Controller;

import com.learn.demo.Dao.UserDao;
import com.learn.demo.Entity.User;
import com.learn.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class JpaController {

    //@Autowired
    //UserDao userDao;

    @Autowired
    UserService userService;

    @GetMapping("/test/rest")
    public List<String> getString(){

        List<String> stringList = new ArrayList<>();

        stringList.add("Szymon");
        stringList.add("Szymcio");

       // userDao.deleteAll();

/*
        for(int i=0;i<10000;i++){
            stringList.add("ssss");
            User user = new User("Szymon"+i,i*i+i,i*i);
            userDao.save(user);
        }
 */
        return stringList;
    }

    @GetMapping("/userlist")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable long id
    ){
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getsingleuser/{id}")
    public User getSingleUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @PutMapping("/saveuser/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable long id, @RequestBody User user
    ) {

        User user1 = userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/createuser")
    public ResponseEntity<Void> createUser(@RequestBody User user) {

        User createdUser = userService.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}


