package com.example.board6.board;

import com.example.board6.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto){
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        int result = mapper.insBoard(entity);
        if(result==1){
            return entity.getIboard();
        }
        return result;
    }

    public int upBoard(BoardUpDto dto){
        int tmp = mapper.upBoard(dto);
        if(tmp==1){return dto.getIboard();}
        return tmp;
    }

    public BoardDetailVo selBoardDetailById(BoardDetailDto dto){
        return mapper.selBoardDetailById(dto);
    };

    public List<BoardVo> selBoardList(BoardSelDto dto){
        dto.setStartIdx((int)Math.ceil((double)mapper.getBoardCount()/dto.getRow()));
        return mapper.selBoardList(dto);
    }



}
