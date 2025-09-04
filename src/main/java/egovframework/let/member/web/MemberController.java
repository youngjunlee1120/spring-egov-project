package egovframework.let.member.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.fdl.string.EgovStringUtil;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.let.join.service.JoinService;
import egovframework.let.join.service.JoinVO;
import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;
import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.temp2.service.Temp2Service;
import egovframework.let.temp2.service.Temp2VO;
import net.sf.json.JSONObject;

@Controller
public class MemberController {

	@Resource(name = "memberService")
    private MemberService memberService;
	
	//회원ID찾기
	@RequestMapping(value = "/member/findId.do")
	public String findId(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		return "/member/FindId";
	}
	
	//회원ID찾기완료
	@RequestMapping(value = "/member/findIdComplete.do")
	public String findIdComplete(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		MemberVO result = memberService.findId(vo);
		if(result == null || EgovStringUtil.isEmpty(result.getEmplyrId())) {
			model.addAttribute("message", "가입 된 회원정보가 없습니다.");
			return "forward:/member/findId.do";
		}
		model.addAttribute("result", result);
		
		return "/member/FindIdComplete";
	}
	
	//회원비밀번호찾기
	@RequestMapping(value = "/member/findPassword.do")
	public String findPassword(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		return "/member/FindPassword";
	}
	
	//회원비밀번호수정
	@RequestMapping(value = "/member/findPasswordRegist.do")
	public String findPasswordRegist(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		MemberVO result = memberService.findPassword(vo);
		if(result == null || EgovStringUtil.isEmpty(result.getEmplyrId())) {
			model.addAttribute("message", "가입 된 회원정보가 없습니다.");
			return "forward:/member/findPassword.do";
		}
		model.addAttribute("result", result);
		
		return "/member/FindPasswordRegist";
	}
	
	//회원비밀번호업데이트
	@RequestMapping(value = "/member/findPasswordComplete.do")
	public String findPasswordComplete(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		memberService.passwordUpdate(vo);
		model.addAttribute("loginMessage", "비밀번호가 업데이트 되었습니다.");
		
		return "forward:/login/login.do";
	}
	
}