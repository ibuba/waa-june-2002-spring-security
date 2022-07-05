package com.edu.miu.repository;
import com.edu.miu.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByEmail(String email); // feching  the  user by email

    User  findByfirstname(String user);
}
