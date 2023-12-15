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

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
//@RequestMapping(value = "/members/*") : 컨트롤러를 구분하는 주소 매핑 ~.me , ~.bo
@RequestMapping(value = "/members/*")
public class MemberController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체 주입 
	@Inject
	private MemberService memberService;
	
	
	
	
	//http://localhost:8088/members/join
	// 회원가입 (정보 입력)
	@RequestMapping (value = "/join", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug("memberJoinGET() 호출");
		
		// 연결된 뷰페이지로 이동
		logger.debug("/views/members/join.jsp");
		
	}
	
	// 회원가입 (정보 처리)
	@RequestMapping (value = "/join", method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO mvo) {
		logger.debug("memberJoinPOST() 호출");
		// 0. 한글처리 (POST 방식으로 데이터 넘길 때 한글 깨짐) -> filter(web.xml) 설정
		// 1. 전달정보 저장
		logger.debug("mvo : " + mvo);
		// 2. 저장한 데이터 DB에 저장 == 서비스 객체를 사용한다
		logger.debug("-------------------서비스 : 회원가입 동작 호출 시작");
		memberService.memberJoin(mvo);
		logger.debug("-------------------서비스 : 회원가입 동작 호출 끝");
		
		// 3. 페이지 이동 (로그인 페이지 - /members/login)
		
		return "redirect:/members/login";
		
	}
	
	// 로그인 - 정보 입력(GET)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug("/members/login 호출 - memberLoginGET() 실행");
		logger.debug("연결된 View(/views/members/login.jsp) 이동");
	}
	
	// 로그인 - 정보 처리(POST)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO mvo, HttpSession session) {
		logger.debug("/members/login 호출 - memberLoginPOST() 실행");
		// 전달받은 정보 저장
		logger.debug("mvo : " + mvo);
		// DB 접근 - 서비스 접근 - 로그인 처리
		MemberVO resultmvo = memberService.memberLogin(mvo);
		
		// 로그인 결과에 따라 페이지 이동
		if(resultmvo != null) {
			// 1) 로그인 성공 = /members/main 페이지 호출(redirect) + 아이디 세션에 저장
			session.setAttribute("id", resultmvo.getUserid());
			logger.debug("-----------------로그인 성공");
			return "redirect:/members/main";
		}
		
		// 2) 로그인 실패 = /members/login 페이지 호출(redirect)
		logger.debug("-----------------로그인 실패");
		return "redirect:/members/login";
	}
	
	@RequestMapping (value = "/main")
	public void main() {
		logger.debug("/members/main 호출 - mainGET() 실행");
		logger.debug("/members/main.jsp View 페이지 이동");
	}
	
	// 로그아웃
	@RequestMapping (value = "/logout")
	public String memberLogout(HttpSession session) {
		logger.debug("/members/logout 호출 - logoutGET() 실행");
		session.invalidate();
		
		logger.debug("/members/login.jsp View 페이지 이동");
		return "redirect:/members/login";
	}
	
	// 회원정보 조회
	@GetMapping(value = "/info") 
	public void memberInfoGET (HttpSession session, Model model) {
		logger.debug("/members/info 호출 - memberinfoGET() 실행");
		
		// 1. 세션영역의 ID 정보 저장
		String id = (String) session.getAttribute("id");
		logger.debug("ID : " + id);
		// 2. 서비스 -> ID를 이용해 회원정보 조회 동작
		MemberVO mvo = memberService.memberInfo(id);
		logger.debug("mvo : " + mvo);
		// 3. DB 조회 결과 View 페이지로 전달 => Model!!!
		model.addAttribute(mvo);
		// model.addAtrribute(memberService.memberInfo(id));
		// 따로 파라미터명을 명시하지 않을 경우 데이터타입의 첫 글자를 소문자로 변경한 것으로 한다
		// 4. 페이지 이동 및 출력(/members/info.jsp
	}
	
	// 회원정보 수정 GET - 기존의 회원정보를 가져와 출력
	@GetMapping (value = "/update")
	public void updateMemberGET(HttpSession session, Model model) {
		logger.debug("/members/update 호출 - memberUpdateGET() 실행");
		
		String userid = (String) session.getAttribute("id");
		model.addAttribute(memberService.memberInfo(userid));
		
	}
	// 회원정보 수정 POST - 수정된 회원정보를 DB에 저장
	@PostMapping (value = "/update")
	public String updateMemberPOST (MemberVO mvo) {
		logger.debug("/members/update 호출 - memberUpdatePOST() 실행");
		
		// 전달받은 정보 저장
		logger.debug("수정 정보 : " + mvo);
		
		// 서비스 - 회원정보 수정 처리
		memberService.memberUpdate(mvo);
		
		return "redirect:/members/main";
	}
	
	// 회원탈퇴 GET
	@GetMapping (value = "/withdrawal")
	public void withdrawalMemberGET () {
		logger.debug("/members/withdrawal 호출 - withdrawalMemberGET () 실행");
		logger.debug("/members/withdrawal.jsp 페이지 이동");
	}
	
	// 회원탈퇴 POST
	@PostMapping
	public String withdrawalMemberPOST(MemberVO mvo, HttpSession session) {
		logger.debug("/members/withdrawal 호출 - withdrawalMemberPOST () 실행");
		mvo.setUserid((String)session.getAttribute("id")); // 이 방식보단 jsp파일에 hidden으로 넘겨받는게 더 편함
		// 서비스 - 회원정보 삭제 (성공or실패)
		int result = memberService.memberWithdrawal(mvo);
			// 성공 - 세션초기화 + 메인페이지 이동
			if(result == 1) {
				session.invalidate();
				logger.debug("회원탈퇴 성공");
				return "redirect:/members/main";
			}
			// 실패 - 이전(삭제)페이지로 이동
			logger.debug("회원탈퇴 실패 - 비밀번호 오류");
			return "redirect:/members/withdrawal";
	}
	
	// 회원정보 조회(관리자)
	@GetMapping (value = "/list")
	public void memberListGET(Model model) {
		logger.debug("/members/list 호출 - memberListGET() 실행");
		
		// 서비스 - 모든 회원조회
		// 전달받은 정보 view페이지로 전달 = Model객체 활용
		model.addAttribute(memberService.getMemberList()); 
		// 전달하는 정보의 변수명을 지정하지 않으면 "데이터타입"+"컬렉션타입"
		
		// members/list.jsp 페이지 이동
	}
	
}

/*
 * 스프링에서의 GET 방식의 의미 : 조회, 출력, 입력 페이지의 방식은 GET방식으로 한다 (잘 모른다 = GET)
 * 
 * 스프링에서의 POST 방식의 의미 : 처리 페이지의 방식은 POST방식으로 한다
 */
