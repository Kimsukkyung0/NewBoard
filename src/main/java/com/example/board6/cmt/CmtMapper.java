package com.example.board6.cmt;

import com.example.board6.cmt.model.CmtRes;
import com.example.board6.cmt.model.CmtSelDto;
import com.example.board6.cmt.model.CmtSelListDto;
import com.example.board6.cmt.model.CmtSelListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(CmtSelDto dto);
    List<CmtSelListVo> selCmtList (CmtSelListDto dto);
    int getTotalCmt(int iboard);
}
