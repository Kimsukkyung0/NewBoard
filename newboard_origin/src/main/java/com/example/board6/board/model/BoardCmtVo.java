package com.example.board6.board.model;

import com.example.board6.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardCmtVo {
    private BoardDetailVo vo;
    private CmtRes cmtlist;
}
