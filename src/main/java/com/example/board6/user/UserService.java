package com.example.board6.user;

import com.example.board6.user.model.UserInsDto;
import com.example.board6.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper){
        this.mapper = mapper;
    }

    public int signInUsers(UserInsDto dto){
        CommonUtils utils = new CommonUtils();
        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        return mapper.signInUsers(dto);//비밀번호 암호화 과정
    }
}
