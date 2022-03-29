package com.accountingservice.repositories;

import com.accountingservice.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by User on 05.02.2022.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByName(String name);


}
