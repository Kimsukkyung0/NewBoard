package com.example.board6.cmt;

import com.example.board6.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper){
        this.mapper = mapper;
    }

    public int insCmt(CmtSelDto dto){
        return mapper.insCmt(dto);
    }
}
