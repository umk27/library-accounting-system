package com.accountingservice.repositories;

import com.accountingservice.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by User on 12.02.2022.
 */
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Optional<Reader> findByName(String name);
}
