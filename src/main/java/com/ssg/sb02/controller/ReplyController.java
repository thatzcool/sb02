package com.ssg.sb02.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.MediaType;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.ssg.sb02.dto.PageRequestDTO;
import com.ssg.sb02.dto.PageResponseDTO;
import com.ssg.sb02.dto.ReplyDTO;
import com.ssg.sb02.service.ReplyService;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;





    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Long> register(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult)throws BindException{

        log.info(replyDTO);

        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();

        Long rno = replyService.register(replyDTO);

        resultMap.put("rno",rno);

        return resultMap;
    }

    @Operation(summary = "Replies of Board")
    @GetMapping(value = "/list/{bno}")
    public PageResponseDTO<ReplyDTO> getList(@PathVariable("bno") Long bno,
                                             PageRequestDTO pageRequestDTO){

        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(bno, pageRequestDTO);

        return responseDTO;
    }

    @Operation(summary = "GET 방식으로 특정 댓글 조회")
    @GetMapping("/{rno}")
    public ReplyDTO getReplyDTO( @PathVariable("rno") Long rno ){

        ReplyDTO replyDTO = replyService.read(rno);

        return replyDTO;
    }

    @Operation(summary =  "DELETE 방식으로 특정 댓글 삭제")
    @DeleteMapping("/{rno}")
    public Map<String,Long> remove( @PathVariable("rno") Long rno ){

        replyService.remove(rno);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }



    @Operation(summary =  "PUT 방식으로 특정 댓글 수정")
    @PutMapping(value = "/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE )
    public Map<String,Long> remove( @PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO ){

        replyDTO.setRno(rno); //번호를 일치시킴

        replyService.modify(replyDTO);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }

}
