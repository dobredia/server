package com.honeywell.server.repository;

import com.honeywell.server.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardDAO extends JpaRepository<CardEntity, String> {

    Optional<CardEntity> findByCardNumber(String cardNumber);

    //boolean existsByCardNumber(String cardNumber);
}
