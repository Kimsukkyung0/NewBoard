package com.example.board6.cmt;

import com.example.board6.cmt.model.CmtSelDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int insCmt(CmtSelDto dto);
}
