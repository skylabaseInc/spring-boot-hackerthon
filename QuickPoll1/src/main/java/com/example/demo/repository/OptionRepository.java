package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {

}
