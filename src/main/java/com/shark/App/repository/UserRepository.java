package com.shark.App.repository;

import com.shark.App.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>  {

   Optional <User> findUserByEmail (String login);
   User findUserByName (String name);
   Boolean existsByName (String name);
   Boolean existsByEmail (String email);


}
