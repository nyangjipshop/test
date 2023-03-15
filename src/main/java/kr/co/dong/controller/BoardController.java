package kr.co.dong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;

import kr.co.dong.HomeController;
import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.BoardReply;
import kr.co.dong.board.BoardService;
import kr.co.dong.board.CodeDTO;
import kr.co.dong.board.paging;
import kr.co.dong.board.jointempDTO;
import kr.co.dong.board.paging;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	// 게시판 전체리스트 조회
		/* 1. 입출력값이 어떻게 되는지(매개변수와 리턴값 확인)
		 * 2. 사용할 데이터 조작방식 선택(get/post)
		 * 추가 : 첫단에 logger.info 적어두면 오류 났을때 찾기 편함
		 */
		@RequestMapping(value="board_dto/freelist", method = RequestMethod.GET)
		public ModelAndView freelist(@RequestParam(value="page", required = false, defaultValue="1") int page, 
								@RequestParam(value="range", required = false, defaultValue="1") int range) throws Exception {
			logger.info("***********list*************");
			// 장바구니 같은 거(조회한 것 넣어줌)
			ModelAndView mav = new ModelAndView();
			// 페이징 처리(전체 건수 조회)
			paging paging = new paging();
			int listCnt = service.paging();
			paging.pageInfo(page, range, listCnt);
			mav.addObject("pagination", paging);
			mav.setViewName("pagination");
			// 게시판 전체 리스트 조회하는 sql을 list라는 이름으로 저장(多건)
			List<BoardDTO> list = service.List(paging); 
			// "list"라는 이름으로 넣어놓음
			mav.addObject("list", list);
			// 화면에 "list" 넘겨줌
			mav.setViewName("free");
			// 공통모듈 CodeDTO codeDTO
			// codeDTO 이용해서 키값 들어오게 세팅(세팅 안 하면 NULL값으로 들어옴)
			// codeDTO.setCodeNm("agreeYn");
			// 서비스 조회해서 codeList에 넣어주기
			// ParameterType = "CodeDTO" / 이름이 codeDTO
			//List<CodeDTO> codeList = service.codeList(codeDTO);
			// mav에 "codeList"이름으로 codeList 추가
			//mav.addObject("codeList", codeList);
			// 리턴값 mav -> mav(참조변수)의 타입 = ModelAndView
			return mav; 
		}
	   
	//shop_detail
	@RequestMapping(value="shop_detail", method = RequestMethod.GET)
	public String selectOne() throws Exception {
		
		return "shop_detail";
	}
	
	//shop_list test
	@RequestMapping(value="shop_list", method = RequestMethod.GET)
	public String selectAll() throws Exception {
		
		return "shop_list";
	}
	//home
	@RequestMapping(value="nyangjipshop", method = RequestMethod.GET)
	public String join()throws Exception {
		return "home";
	}	
		
	//선택목록(글읽기)
	@RequestMapping(value="board_dto/fr_detail", method = RequestMethod.GET)
	public String fr_detail(@RequestParam("b_p_bno") int b_p_bno, Model model) throws Exception {
		BoardDTO board = service.board(b_p_bno);
	    model.addAttribute("board",board);
	    System.out.println(board.getB_p_bno());
	    board.getB_p_bno();
	    //List<BoardReply> list = service.getDetail(bno);
	    //model.addAttribute("list", list);
	    return "fr_detail";
	 }
	
//	글쓰기 폼
	@RequestMapping(value="board_dto/fr_register", method = RequestMethod.GET)
	public String insertBoard() {
		
		return "fr_register";
	}
	
//	글쓰기 저장
	@RequestMapping(value="board_dto/fr_register", method = RequestMethod.POST)
	public String insertBoard(BoardDTO boardDTO, HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		int r = service.register(boardDTO);
		
		return "redirect:freelist";
	}
	
	// 회원가입 저장
	@RequestMapping(value="board/join", method = RequestMethod.POST)
	public String join(jointempDTO jointempDTO, HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		//jointempDTO.setTel(jointempDTO.getTel1()+"-"+jointempDTO.getTel2()+"-"+jointempDTO.getTel3());
		//int r = service.Join(jointempDTO);
		
		return "redirect:list";
	}
	
	
	//	글 수정 폼(기존데이터 전송- 글읽기)
	@RequestMapping(value="board_dto/fr_update", method = RequestMethod.GET)
	public String updateBoard(@RequestParam("b_p_bno") int b_p_bno, Model model) throws Exception {
		BoardDTO board = service.board(b_p_bno);
		model.addAttribute("board",board);
		return "fr_update";
	}	
	
	//	글 수정 저장
	@RequestMapping(value ="board_dto/fr_update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rttr,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int r = service.update(boardDTO);
		
		// 수정에 성공하면 목록보기로 이동
		if(r>0) {
			rttr.addFlashAttribute("msg", "수정에 성공하였습니다.");
			return "redirect:freelist";
		}

		// 수정에 실패하면 수정보기 화면으로 이동
		return "redirect:fr_update?b_p_bno="+boardDTO.getB_p_bno();

	}
	
	// 글 삭제
	@RequestMapping(value="board/delete",method = RequestMethod.GET)
	public String deleteBoard(@RequestParam("b_p_bno") int b_p_bno, RedirectAttributes rttr) throws Exception {
		int r = service.delete(b_p_bno);
		
		// 삭제에 성공하면 게시판 목록보기로 이동
		if(r>0) {
			rttr.addFlashAttribute("msg", "삭제에 성공하였습니다.");
			return "redirect:list";
		}
		// 삭제에 실패하면 기존상세보기 화면으로 이동
		return "redirect:delete?b_p_bno="+b_p_bno;
	}
	/*
	@GetMapping(value="board/reply")
	public String reply() {
		return "reply";
	}
	
	@PostMapping(value="board/reply")
	public String reply(BoardReply boardReply) throws Exception {
		int r = service.reply(boardReply);
		if(r>0) {
			return "redirect:detail?bno=" + boardReply.getBno();
		}
		return "reply";
	}

	@GetMapping(value="board/replyupdate")
	public String replyUpdate(@RequestParam("reno")int reno, Model model) throws Exception {
		BoardReply boardReply = service.detailReply(reno);
		model.addAttribute("boardReply", boardReply);
		return "replyupdate";
	}
	
	@PostMapping(value="board/replyupdate")
	public String replyUpdate(BoardReply boardReply) throws Exception {
		logger.info("!!!!!!!!!!!!!");
		int r = service.replyUpdate(boardReply);
		if(r>0) {
			return "redirect:detail?bno="+boardReply.getBno();
		}
		return "replyupdate";
	}
	
	@RequestMapping(value="board/replyDelete", method = {RequestMethod.GET, RequestMethod.POST})
	public String replyDelete(BoardReply boardReply) throws Exception {
		logger.info("!!!!!!!!!!!!!"+boardReply.getBno());
		int r = service.replyDelete(boardReply);
		if(r>0) {
			return "redirect:detail?bno="+boardReply.getBno();
		}
		return "replyupdate";
	}

	// ajax 매핑과 메소드를 구현
	// json처리를 위한 라이브러리가 필요함 => jackson-databind, jackson-core
	// result type도 json 타입이므로, map으로 보내줘야함. String 안됨
	@ResponseBody //ajax는 꼭 작성해줘야함
	@RequestMapping(value="board/test", method = RequestMethod.POST)
	public Map<String,Object> test(@RequestParam("msg") String msg) {
		logger.info("msg : "+msg);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("status","OK");
		return result;
	}
	
	//ajax 댓글에 대한 매핑과 메소드를 구현(모델에 싣지 않고 그대로 return)
	@ResponseBody
	@RequestMapping(value="board/replylist", method = RequestMethod.POST)
	public List<BoardReply> replylist(@RequestParam("bno")int bno) throws Exception {
		return service.getDetail(bno);
	}
	
	//ajax 댓글 쓰기
	@ResponseBody
	@RequestMapping(value="board/reply2", method = RequestMethod.POST)
	public int reply2(BoardReply boardReply) throws Exception {
		return service.reply(boardReply);
	}
	
	//ajax 댓글 수정
	@ResponseBody
	@RequestMapping(value="board/replyupdate2", method = RequestMethod.POST)
	public int replyupdate2(BoardReply boardReply) throws Exception {
		return service.replyUpdate(boardReply);
	}
	
	//ajax 댓글 삭제
	@ResponseBody
	@RequestMapping(value="board/replydelete2", method = RequestMethod.POST)
	public int replydelete2(BoardReply boardReply) throws Exception {
		return service.replyDelete(boardReply);
	}
	*/
	
//	로그인 폼으로 가는 매핑 board/login -> login(.jsp)
	@RequestMapping(value="board/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
//	로그인 폼으로 가는 매핑 board/login -> login(.jsp)
	@GetMapping(value="board/logOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	로그인 처리하기 (DAO)  : 성공하면 redirect:/ (또는 home.jsp)
//	                           세션부여함.
	@RequestMapping(value="board/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(map);
		// 서비스 호출
		Map user = service.login(map);
		
		if(user == null) {  // 로그인 실패
			
			return "redirect:login";
		}else {   // 로그인 성공
			// 세션 부여
			session.setAttribute("user", user);
			return "redirect:/";
		}		
	}
}






