package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository){

        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName() , request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }

    public void updateUser (UserUpdateRequest request){
        if (userJdbcRepository.isUserNotExist( request.getId())) {
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(request.getName() , request.getId());
    }
    public void deleteUser(String name){
        // query는 리스트 형태임 id가져와서 있으면 [0] 이며, 없으면 [] .isEmpty 하게 되면 true false 반환함
        System.out.println("n1");
        if (userJdbcRepository.isUserNotExist(name)) {
            System.out.println("n2");
            throw new IllegalArgumentException();
        }
        System.out.println("n3");
        userJdbcRepository.deleteUser(name);
    }
}
