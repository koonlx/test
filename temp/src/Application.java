import java.util.HashMap;
import java.util.Map;

import controller.FrontController;
import domain.dto.MemberDto;

public class Application {
    public static void main(String[] args) throws Exception {

        FrontController controller = new FrontController();
        Map<String, Object> params = new HashMap<>();
        // 회원가입
        // params.put("Insert", new MemberDto("재형이", "1111", "test@test.com", 1099555775));
        // controller.execute("/member", 1, params);
        // 모든 사용자 조회
        params.put("SelectAll", new Object());
        controller.execute("/member", 4, params);
    }
}
