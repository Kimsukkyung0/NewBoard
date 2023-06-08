package com.example.board6.user;

import com.example.board6.user.model.UserInsDto;
import com.example.board6.user.model.UserPhotoUpDto;
import com.example.board6.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper){
        this.mapper = mapper;
    }

    public int signInUsers(UserInsDto dto){
        // 성별을 주입해서 전달.
        char tmp = Character.toUpperCase(dto.getGender());
        if(!(tmp=='F'||tmp=='M')){
            return -1;
        }
        dto.setGender(tmp);

        //비밀번호 암호화 과정
        CommonUtils utils = new CommonUtils();
        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        return mapper.signInUsers(dto);
    }

    public int upUserPhoto(UserPhotoUpDto dto,MultipartFile pic){

        return mapper.upUserPhoto(dto);
    };
}
