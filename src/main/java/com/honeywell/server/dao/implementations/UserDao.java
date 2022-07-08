package com.honeywell.server.dao.implementations;

import com.honeywell.server.dao.Dao;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class UserDao implements Dao {
    @Override
    public Optional get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public int save(Object o) {
        return 0;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
