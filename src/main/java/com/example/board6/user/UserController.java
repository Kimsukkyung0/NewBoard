package com.example.board6.user;

import com.example.board6.user.model.UserInsDto;
import com.example.board6.user.model.UserLoginDto;
import com.example.board6.user.model.UserPhotoUpDto;
import com.example.board6.user.model.UserLoginVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입", description = "" + "uid:[12] 회원아이디<br>" + "upw:[100] 회원비밀번호<br>" + "name:[30] 회원 이름" +
            "gender : [1]성별 (M:남성, F:여성),<br>" + "addr:[100] 주소,<br>")
    public int signInUsers(@RequestBody UserInsDto dto) {
        return service.signInUsers(dto);
    }

    @PatchMapping(name = "/pic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public int upUserPhoto(@RequestPart MultipartFile pic, @RequestParam String uid) {
        UserPhotoUpDto dto = new UserPhotoUpDto();
        dto.setUid(uid);
        return service.upUserPhoto(dto, pic);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = ""
            + "(1):로그인 성공,"
            + "(2):아이디 없음,"
            + "(3):비밀번호다름")
    public int LoginUser(@RequestBody UserLoginDto dto) {
        return service.LoginUser(dto);
    }

    @DeleteMapping
    @Operation(summary = "회원삭제", description = ""
            + "(1):탈퇴성공,"
            + "(2):회원정보를 찾을 수 없음,"
            + "(3):비밀번호다름")
    public int signOutUser(@RequestBody UserLoginDto dto) {
        return service.deleteUser(dto);
    }
}

