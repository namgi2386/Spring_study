package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // exists 예시코드
//    User findByName(String name);
//    boolean existsByName(String name);

    Optional<User> findByName(String name);
    List<User> findAllByNameAndAge(String name , int age);
}
