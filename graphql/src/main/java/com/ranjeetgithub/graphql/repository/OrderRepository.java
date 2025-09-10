package com.ranjeetgithub.graphql.repository;

import com.ranjeetgithub.graphql.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
