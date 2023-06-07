package com.example.board6.user;

import com.example.board6.user.model.UserInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int signInUsers(UserInsDto dto);
}
