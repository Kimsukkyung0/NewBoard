package com.example.board6.cmt;

import com.example.board6.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service){
        this.service = service;
    }

    @PostMapping
    public int InsCmt(@RequestBody CmtSelDto dto, @RequestParam int iboard,@RequestParam int iuser){
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.insCmt(dto);
    }
}
