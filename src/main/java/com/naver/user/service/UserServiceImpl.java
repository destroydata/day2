package com.naver.user.service;

import com.naver.user.dao.UserDao;
import com.naver.user.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();

//    public UserServiceImpl() {
//        users.add(new User("id","123"));
//        users.add(new User("id1","123"));
//    }
    @Autowired
    private UserDao userDao;
    @Override
    public boolean login(String id, String pw) {
        User loginedId = userDao.login(id, pw);
        System.out.println(loginedId);
        if(loginedId==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean signup(String id, String pw, String name) {
        // 중복 체크 로직
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId().equals(id))
//                return false;
//        }
//        // 없으면 add
//        return users.add(new User(id,pw));

        return userDao.signup(id, pw, name) != 0;

    }
}
