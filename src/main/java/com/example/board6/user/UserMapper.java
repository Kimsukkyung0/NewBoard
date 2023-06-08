package com.example.board6.user;

import com.example.board6.user.model.UserLoginDto;
import com.example.board6.user.model.UserInsDto;
import com.example.board6.user.model.UserPhotoUpDto;
import com.example.board6.user.model.UserLoginVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int signInUsers(UserInsDto dto);
    int upUserPhoto(UserPhotoUpDto dto);
    int deleteUser(UserLoginDto dto);
    UserLoginVo loginUser(UserLoginDto dto);
}
