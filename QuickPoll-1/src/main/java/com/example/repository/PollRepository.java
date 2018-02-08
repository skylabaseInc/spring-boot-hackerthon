package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {

}
