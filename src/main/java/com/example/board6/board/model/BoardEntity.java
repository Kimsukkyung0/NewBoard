package com.example.board6.board.model;

import lombok.Data;

@Data
public class BoardEntity {
    private int iboard;
    private String title;
    private String ctnt;
    private String iuser;
    private String createdAt;
    private String updatedAt;

}
