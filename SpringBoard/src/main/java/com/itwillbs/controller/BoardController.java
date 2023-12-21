package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageVO;
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
	public String listALLGET(Model model, @ModelAttribute("result") String result 
			, HttpSession session) throws Exception {
		logger.debug("listALLGET() 호출");
		session.setAttribute("viewcntCheck", true);
		
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
			Model model, HttpSession session) throws Exception {

		// 전달정보
		logger.debug("bno : " + bno);
		if ((boolean) session.getAttribute("viewcntCheck")) {
			
			logger.debug(bService.updateViewcnt(bno));
			session.setAttribute("viewcntCheck", false);
		}
		// 조회수 증가 - bno 글 조회수 1 증가(페이지 호출당 1번씩 증가)
		
		// bno로 글정보 조회
		// 뷰페이지 이동 + 정보전달
		model.addAttribute(bService.getBoard(bno));
		// /board/read.jsp
		
	}
	
	// 게시판 글 수정 - GET
	// http://localhost:8088/board/modify?bno=7
	@GetMapping (value = "/modify")
	public void modifyGET(@RequestParam ("bno") int bno, 
			Model model) throws Exception {
		// 전달정보 
		logger.debug("수정 글번호 : " + bno);
		
		// bno로 글정보 조회
		// 뷰페이지 이동 + 정보전달
		model.addAttribute(bService.getBoard(bno));
		
	}
	
	// 게시판 글 수정 - POST
	@PostMapping (value = "/modify")
	public String modifyPOST(@ModelAttribute ("boardVO") BoardVO bvo, RedirectAttributes rttr) throws Exception {
		// 전달받은 정보 저장(수정 내용)
		logger.debug("수정 내용 : " + bvo);
		// 서비스 - 정보수정 동작
		bService.updateBoard(bvo);
		// 처리 완료 후 페이지 이동(리스트)
		// + 수정 완료, 리스트에서 출력하기
		rttr.addFlashAttribute("result", "modified");
		
		return "redirect:/board/listAll";
	}
	
	// 게시판 글 삭제
	@PostMapping (value = "/delete")
	public String delete(@RequestParam("bno") int bno, 
			RedirectAttributes rttr) throws Exception{
		logger.debug("cc : delete 호출");
		
		bService.deleteBoard(bno);
		logger.debug("cc : " + bno + "번 글 삭제 완료");
		rttr.addFlashAttribute("result", "deleted");
		return "redirect:/board/listAll";
	}
	
	// 게시판 리스트 - GET
		// http://localhost:8088/board/listPage?page=1
		@GetMapping (value = "/listPage")
		public String listPageGET(Model model, @ModelAttribute("result") String result 
				, HttpSession session, Criteria cri) throws Exception {
			logger.debug("listALLGET() 호출");
			session.setAttribute("viewcntCheck", true);
			
//			Criteria cri = new Criteria();
//			cri.setPage(16);
//			cri.setPageSize(10);
			
			// 서비스 - DB의 저장된 글을 가져오기
			List<BoardVO> bList = bService.boardListPage(cri);
			logger.debug("CC, bList : " + bList);
			
			// 페이지 블럭 정보 준비 후 -> view 페이지 전달
			PageVO pvo = new PageVO();
			pvo.setCri(cri);
			pvo.setTotalCount(13312);
			logger.debug("cc, pvo : " + pvo);
			model.addAttribute("pvo", pvo);
			
			// 데이터를 연결된 뷰페이지로 전달
			model.addAttribute("bList", bList);
			return "/board/listAll";
		}
/*
 * 페이징 처리 
 * 
 * 0) 반드시 GET방식으로만 처리한다
 * 1) 원하는 만큼의 데이터를 가져와서 출력 
 * 		- 쿼리문 limit #{startPage},#{pageSize} + Criteria
 * 2) 페이지 블럭 생성
 * 		- 시작 페이지 번호
 * 		- 끝 페이지 번호
 * 		- 전체 데이터(글)의 갯수
 * 		- 이전 페이지 링크(boolean)
 * 		- 다음 페이지 링크(boolean)
 * 
 * 		ex) 총 122개 / pageSize=10
 * 			- 1페이지 / 시작 페이지 번호 : 1, 끝 페이지 번호 : 10 / 이전 : N, 다음 : Y
 * 			- 7페이지 / 시작 페이지 번호 : 1, 끝 페이지 번호 : 10 / 이전 : N, 다음 : Y
 * 			- 12페이지 / 시작 페이지 번호 : 11, 끝 페이지 번호 : 20->13 / 이전 : Y, 다음 : N
 * 3) 본문, 수정, 삭제 처리 후 리스트 이동 시 기존 정보 유지
 * 
 * a태그 : 네이버 쇼핑 / 유사한 코드의 반복적인 동작 수행
 * 		=> 검색엔진 노출이 쉽다
 * form태그 : 쿠팡 / input 태그를 사용해서 처리한다
 * 		=> 빠른 데이터 처리
 */

}

