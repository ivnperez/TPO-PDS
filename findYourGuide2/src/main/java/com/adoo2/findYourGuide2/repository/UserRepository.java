package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findById(long id);
}
