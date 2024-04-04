package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.dto.MemberDto;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberController implements SubController {
    private MemberService memberService;
	
	public MemberController(){
		
		try {
			memberService=MemberServiceImpl.getInstance();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 6 Login 7 Logout 
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
        System.out.println("MemberController's execute()");
        
        switch (serviceNo) {
            case 1:
            // 파라미터
            MemberDto dto = (MemberDto) params.get("Insert");
            // 유효성
            if (!true)
                return null;
            // 서비스
            boolean isSignUp = false;
            try {
                isSignUp = memberService.signUp(dto);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 뷰
			Map<String,Object> result = new HashMap<>();
			result.put("response", isSignUp);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                // 파라미터
                Object obj = params.get("SelectAll");
                // 유효성
                // 서비스
                List<MemberDto> view = null;
                try {
                    view = memberService.getAllUsers();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // 뷰
                Map<String, List<MemberDto>> allUsersResult = new HashMap<>();
                allUsersResult.put("response", view);
                break;
            case 5:
                // // 파라미터
                // MemberDto insertDto = (MemberDto) params.get("Select");
                // String name = insertDto.getUsername();
                // // 유효성
                // if (!true)
                //     return null;
                // MemberDto Selected = null;
                // // 서비스
                // try {
                //     Selected = memberService.getProfile(name);
                // } catch (Exception e) {
                //     e.printStackTrace();
                // }
                // // 뷰
                // Map<String,Object> selectResult = new HashMap<>();
			    // selectResult.put("response", Selected);
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            default:
                break;
        }
		return null;
	}

}
