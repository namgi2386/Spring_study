package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory , Long> {
    boolean existsByBookNameAndIsReturn(String name , boolean isReturn);

//    Optional<UserLoanHistory> findByUserIdAndBookName(long userId , String BookName); 비즈니스로직으로 이젠 필요없음
}
