package com.myprojects.miniproject.repository;

import com.myprojects.miniproject.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    public List<Item> findByName(String name);
}
