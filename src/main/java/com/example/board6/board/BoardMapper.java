package com.example.board6.board;

import com.example.board6.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity);
    int upBoard(BoardUpDto dto);
    BoardDetailVo selBoardDetailById(BoardDetailDto dto);
    List<BoardVo> selBoardList(BoardSelDto dto);
    int getBoardCount();
}
