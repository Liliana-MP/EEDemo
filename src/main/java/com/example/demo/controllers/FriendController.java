package com.example.demo.controllers;

import com.example.demo.models.Friend;
import com.example.demo.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping(path = "/add")
    public String addFriend(@RequestParam String firstName, @RequestParam String lastName,
                            @RequestParam String mobile, @RequestParam String email){
        Friend friend = new Friend();
        friend.setFirstName(firstName);
        friend.setLastName(lastName);
        friend.setMobile(mobile);
        friend.setEmail(email);

        friendRepository.save(friend);

        return "Friend added";
    }

    @GetMapping(path = "/all")
    public Iterable<Friend> allFriends(){
        Iterable<Friend> list = friendRepository.findAll();

        return list;
    }

    @GetMapping(path = "/remove/{id}")
    public String  removeFriend(@PathVariable Long id){
        Friend friend = friendRepository.findById(id).get();

        friendRepository.delete(friend);

        return "Removed friend";
    }


}
