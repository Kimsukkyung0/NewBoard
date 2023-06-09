package com.example.board6.cmt;

import com.example.board6.cmt.model.CmtRes;
import com.example.board6.cmt.model.CmtSelDto;
import com.example.board6.cmt.model.CmtSelListDto;
import com.example.board6.cmt.model.CmtSelListVo;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cmt")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service){
        this.service = service;
    }

    @PutMapping
    public int InsCmt(@RequestBody CmtSelDto dto, @RequestParam int iboard,@RequestParam int iuser){
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.insCmt(dto);
    }
    @GetMapping("/{iboard}")
    public CmtRes CmtSelList(@PathVariable int iboard,
                             @RequestParam(defaultValue = "5") @Min('1') int row,
                             @RequestParam (defaultValue = "1")@Min('1') int page){
        CmtSelListDto dto = new CmtSelListDto();
        dto.setIboard(iboard);
        dto.setRow(row);
        dto.setPage(page);
        return service.selCmtList(dto);
    }
}
