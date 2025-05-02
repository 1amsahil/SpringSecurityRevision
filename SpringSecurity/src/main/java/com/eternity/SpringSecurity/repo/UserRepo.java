package com.eternity.SpringSecurity.repo;

import com.eternity.SpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>
{

}
