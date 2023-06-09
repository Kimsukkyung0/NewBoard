package com.example.board6.board.model;


import com.example.board6.cmt.model.CmtRes;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String uid;
    private String mainPic;

}
