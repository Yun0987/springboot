package com.smhrd.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.board.entity.BoardEntity;
import com.smhrd.board.service.BoardService;

@RestController
public class BoardRestController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/search")
	public List<BoardEntity> search(@RequestParam String type, @RequestParam String keyword) {
		// 필요한 것 --> type, keyword
		
		//DB 연결
		// --> service 객체 기능 구현
		return boardService.search(type, keyword);
	}

}
