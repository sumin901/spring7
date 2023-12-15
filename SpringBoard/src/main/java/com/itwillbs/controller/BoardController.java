package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService bService;
	
	// 글쓰기 - GET
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist",method = RequestMethod.GET)
	public void registGET() throws Exception{
		logger.debug("/board/regist -> registGET() 호출 ");
		logger.debug("/board/regist.jsp 뷰페이지로 이동");
	}
	
	// 글쓰기 - POST
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.debug("registPOST() 호출 ");
		// 한글 인코딩(필터)
		// 전달정보 저장
		logger.debug(" vo : "+vo);
		
		// 서비스 - DB에 글쓰기(insert) 동작 호출
		bService.write(vo);
		logger.debug("registPOST(), 글 작성 완료");
		
		rttr.addFlashAttribute("result", "CREATED");
		
		logger.debug("/board/listAll 이동");
		return "redirect:/board/listAll";
	}
	
	// 게시판 리스트 - GET
	// http://localhost:8088/board/listAll
	@GetMapping (value = "/listAll")
	public String listALLGET(Model model, @ModelAttribute("result") String result) throws Exception {
		logger.debug("listALLGET() 호출");
		// 서비스 - DB의 저장된 글을 가져오기
		List<BoardVO> bList = bService.boardListALL();
		logger.debug("CC, bList : " + bList);
		// 데이터를 연결된 뷰페이지로 전달
		model.addAttribute("bList",bService.boardListALL());
		
		return "/board/listAll";
	}
	
	// 글 본문보기 - GET
	// http://localhost:8088/board/read?bno=1
	@GetMapping (value = "/read")
	public void readGET(@RequestParam("bno") int bno, 
			Model model) throws Exception {

		// 전달정보
		logger.debug("bno : " + bno);
		
		// bno로 글정보 조회
		// 뷰페이지 이동 + 정보전달
		model.addAttribute(bService.getBoard(bno));
		// /board/read.jsp
		
	}
	
	// 게시판 글 수정 - GET
	@GetMapping (value = "/modify")
	public void modify(@RequestParam ("bno") int bno, 
			Model model) throws Exception {
		// 전달정보 
		logger.debug("bno : " + bno);
		
		// bno로 글정보 조회
		// 뷰페이지 이동 + 정보전달
		model.addAttribute(bService.getBoard(bno));
		
	}
	
	// 게시판 글 수정 - POST
	
	
	

}
