package com.example.board6.board;

import com.example.board6.board.model.*;
import com.example.board6.cmt.CmtService;
import com.example.board6.cmt.model.CmtRes;
import com.example.board6.cmt.model.CmtSelListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService cmtService;

    @Autowired
    public BoardService(BoardMapper mapper,CmtService cmtService){
        this.mapper = mapper;
        this.cmtService = cmtService;
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

    public BoardCmtVo selBoardDetailById(BoardDetailDto dto){
        CmtSelListDto sDto = new CmtSelListDto();
           sDto.setIboard(dto.getIboard());

        return BoardCmtVo.builder()
                .vo(mapper.selBoardDetailById(dto))
                .cmtlist(cmtService.selCmtList(sDto))
                .build();
    };

    public List<BoardVo> selBoardList(BoardSelDto dto){
        dto.setStartIdx((int)Math.ceil((double)mapper.getBoardCount()/dto.getRow()));
        return mapper.selBoardList(dto);
    }



}
