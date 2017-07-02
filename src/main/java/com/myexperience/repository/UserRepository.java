package com.myexperience.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexperience.domain.User;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>
{
     boolean findByUserNameLike( String user_name );
     boolean findByPassWordLike(String pass );
}

