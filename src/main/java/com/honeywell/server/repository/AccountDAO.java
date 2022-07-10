package com.honeywell.server.repository;

import com.honeywell.server.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDAO extends JpaRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findById(Integer id);

}