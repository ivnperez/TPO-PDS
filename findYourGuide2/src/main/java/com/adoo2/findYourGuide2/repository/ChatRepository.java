package com.adoo2.findYourGuide2.repository;

import com.adoo2.findYourGuide2.model.Chat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat, Long> {
    List<Chat> findAll();
    Chat findById(long id);
}
