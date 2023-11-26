package com.example.board6.cmt;

import com.example.board6.cmt.model.CmtRes;
import com.example.board6.cmt.model.CmtSelDto;
import com.example.board6.cmt.model.CmtSelListDto;
import com.example.board6.cmt.model.CmtSelListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper){
        this.mapper = mapper;
    }

    public Integer insCmt(CmtSelDto dto){
        return mapper.insCmt(dto);
    }

    public CmtRes selCmtList (CmtSelListDto dto){

        dto.setStartIdx(dto.getRow()*(dto.getPage()-1));

        List<CmtSelListVo> list = mapper.selCmtList(dto);

        int totalPage = (int)Math.ceil(mapper.getTotalCmt(dto.getIboard())/(double)dto.getRow());
        //iboard에 따른 보여줄 코멘트 페이지 수 구하기
        int isMore = totalPage > dto.getPage()? 1 : 0;

        return CmtRes.builder()
                     .list(list)
                     .isMore(isMore)
                     .build();
    }
}
