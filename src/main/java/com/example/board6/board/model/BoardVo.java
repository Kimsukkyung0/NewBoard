package com.example.board6.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardVo {
    private int iboard;
    private String title;
    private String iuser;
    private String createdAt;
//
//    limit #{startIdx},#{row}
}
