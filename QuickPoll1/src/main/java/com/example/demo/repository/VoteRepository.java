package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

}
