package com.example.board6.cmt.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CmtRes {
    private List<CmtSelListVo> list;
    private int isMore;
}
