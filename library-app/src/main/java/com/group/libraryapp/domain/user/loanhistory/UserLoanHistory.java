package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;
import jakarta.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

//    private long userId; 수정전
    @ManyToOne // N:1 관계
    private User user;

    private String bookName;
    private boolean isReturn;

    protected UserLoanHistory(){}

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }
    public void doReturn(){
        this.isReturn = true;
    }

}
