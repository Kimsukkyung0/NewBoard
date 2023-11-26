package com.example.board6.board;

import com.example.board6.board.model.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service){
        this.service = service;
    }

    @PostMapping
    public int postBoard(@RequestBody BoardInsDto dto){
        return service.insBoard(dto);
    }

    @PutMapping
    public int putBoard(@RequestBody BoardUpDto dto,@RequestParam int iboard){
        dto.setIboard(iboard);
        return service.upBoard(dto);
    }

    @Tag(name="게시글과 댓글 함께보기")
    @GetMapping("/{iboard}")
    public BoardCmtVo selBoardDetailById(@PathVariable int iboard){
        BoardDetailDto dto = new BoardDetailDto();//이새끼가 약간수상
        dto.setIboard(iboard);
        return service.selBoardDetailById(dto);
    }

    @GetMapping
    public List<BoardVo> selBoardList(@RequestParam(defaultValue = "30") int row,
                                      @RequestParam(defaultValue = "1") int page) {
        BoardSelDto dto = new BoardSelDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoardList(dto);
    }
}
