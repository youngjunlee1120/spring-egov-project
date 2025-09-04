package egovframework.let.join.service.copy;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

public interface JoinService {
	
	//아이디 중복체크
	public int duplicateCheck(JoinVO vo) throws Exception;
	
	//회원 가입
	public String insertJoin(JoinVO vo) throws Exception;
}
