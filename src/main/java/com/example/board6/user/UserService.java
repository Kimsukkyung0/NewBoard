package com.example.board6.user;

import com.example.board6.user.model.UserLoginDto;
import com.example.board6.user.model.UserInsDto;
import com.example.board6.user.model.UserPhotoUpDto;
import com.example.board6.user.model.UserLoginVo;
import com.example.board6.utils.CommonUtils;
import com.example.board6.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    private final UserMapper mapper;

    @Value("${file.dir}")
    private String fileDir;

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
        String centerPath = String.format("user/%s",dto.getUid());
        String dirPath = String.format("%s/%s",fileDir,centerPath);
        //결과물  : uppserPath = d:/download/board6/user/id/

        File file = new File(dirPath);
        if(!(file.exists())){ //지정위치에 폴더가 있는지 확인 후,없다면 새로만들기
            file.mkdirs();
        }

        FileUtils utils = new FileUtils();

        String ext = utils.getExt(pic.getOriginalFilename());
        String OriginalFileName = utils.getOriginalFileName(pic.getOriginalFilename());
        String rdName = utils.getRdUuidName();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String update_date = simpleDateFormat.format(new Date());

        String FileName = rdName+update_date+"."+ext;
        String savedFilePath = String.format("%s/%s",centerPath,FileName);
        //파일명 생성
        dto.setMainPic(savedFilePath);
        String targetPath = String.format("%s/%s",fileDir,savedFilePath);


        File target = new File(targetPath);

        try{
            pic.transferTo(target);
        } catch(Exception e){
            return 0;
        }

        try{
            int result = mapper.upUserPhoto(dto);
            if(result == 0){
                throw new Exception("프로필 사진을 등록할 수 없습니다");
            }
        }catch(Exception e){
            target.delete();
            return 0;
        }

        return 1;
    };

    public int LoginUser(UserLoginDto dto){
        CommonUtils utils = new CommonUtils();
        UserLoginVo vo = mapper.loginUser(dto);

        if(vo==null){
            return 2;
        }//아이디없음
        String hashPw = utils.encodeSha256(dto.getUpw());

        if(vo.getUid().equals(dto.getUid()) && vo.getUpw().equals(hashPw)){
            return 1;
        }//성공
        return 3;
        //비번다름
    };

    public int deleteUser(UserLoginDto dto){
        CommonUtils commonUtils = new CommonUtils();
        String tmpPw = commonUtils.encodeSha256(dto.getUpw());
        UserLoginVo vo = mapper.loginUser(dto);
        //
        if(vo==null){
            return 2;//2:회원삭제실패. id가 다름
        };
        if(vo.getUpw().equals(tmpPw)){
            dto.setUpw(tmpPw);
            return mapper.deleteUser(dto);//1 : 회원삭제성공
        }

        return 3; // 3:회원삭제실패 : pw가 다름
    }
}
