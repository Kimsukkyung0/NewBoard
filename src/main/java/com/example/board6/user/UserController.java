package com.example.board6.user;

import com.example.board6.user.model.UserInsDto;
import com.example.board6.user.model.UserPhotoUpDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/signin")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입", description = ""+"uid:[12] 회원아이디<br>" + "upw:[100] 회원비밀번호<br>"+"name:[30] 회원 이름"+
    "gender : [1]성별 (M:남성, F:여성),<br>" + "addr:[100] 주소,<br>")

    public int signInUsers(@RequestBody UserInsDto dto){
        return service.signInUsers(dto);
    }

    @PatchMapping(name="/pic",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public int upUserPhoto(@RequestPart MultipartFile pic , @RequestParam String uid){
        UserPhotoUpDto dto = new UserPhotoUpDto();
        dto.setUid(uid);
        return service.upUserPhoto(dto,pic);
    }
}
