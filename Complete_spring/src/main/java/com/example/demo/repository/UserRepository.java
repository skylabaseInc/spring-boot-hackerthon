package com.example.demo.repository;
import com.example.demo.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRepository extends CrudRepository<UserModel, Long> {
	UserModel findByEmail(@Param ("email") String email);

}
