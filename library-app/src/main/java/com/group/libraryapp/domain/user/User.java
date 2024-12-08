package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id // jakarta.persistence >> 이걸 primary key로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id = null;

    @Column(nullable = false, length = 20) // name varchar(20)
//    @Column(nullable = false, length = 20, name="name") name 똑같으니까 생략가능
    private String name;
    // age의 경우 null 가능하고 이름도 같으면 굳이 매핑할 필요없음
    private Integer age;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true) // 1:N 설정
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public User(){} // jpa사용하려면 기본생성자 필수

    public User(String name, Integer age) {
        if (name==null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)입력됨", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }
    public void updateName(String name){
        this.name = name;
    }
    public void loanBook(String bookName){
        this.userLoanHistories.add(new UserLoanHistory(this,bookName));
    }
    public void returnBook(String bookName){
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst().orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();
    }
}
