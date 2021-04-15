package com.example.demo.repositories;

import com.example.demo.models.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {

    List<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    List<Friend> findByFirstName(String firstName);
    List<Friend> findByLastName(String lastName);
    List<Friend> findByMobile(String mobile);
    List<Friend> findByEmail(String email);
}
