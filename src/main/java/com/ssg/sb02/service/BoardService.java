package com.ssg.sb02.service;

import com.ssg.sb02.dto.BoardDTO;
import com.ssg.sb02.dto.PageRequestDTO;
import com.ssg.sb02.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void modify(BoardDTO boardDTO);

    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
