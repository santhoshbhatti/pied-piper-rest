package com.pp.rest.users.persistent.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.rest.users.vos.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer>{

}
