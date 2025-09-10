package com.ranjeetgithub.graphql.repository;

import com.ranjeetgithub.graphql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    //custom query methods
    // custom finder methods
}
