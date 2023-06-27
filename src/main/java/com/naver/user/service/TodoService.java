package com.naver.user.service;

import com.naver.user.dao.TodoDao;
import com.naver.user.domain.dto.TodoJoinUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<TodoJoinUser> findAll(){
        return todoDao.findAll();
    }
}
