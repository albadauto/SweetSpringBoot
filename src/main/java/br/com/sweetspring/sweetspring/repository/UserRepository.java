package br.com.sweetspring.sweetspring.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sweetspring.sweetspring.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByEmail(String email);
}
