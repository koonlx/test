package service;

import java.lang.reflect.Member;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import domain.dao.MemberDao;
import domain.dao.MemberDaoImpl;
import domain.dao.SessionDao;
import domain.dto.MemberDto;
import domain.dto.SessionDto;

public class MemberServiceImpl implements MemberService {

    private List<Integer> SessionIdList;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MemberDao memberDao;
    private SessionDao sessionDao;

    private static MemberService instance;

    public static MemberService getInstance() throws Exception {
        if (instance == null)
            instance = new MemberServiceImpl();
        return instance;
    }
    
    private MemberServiceImpl() throws Exception {
        System.out.println("MemberServiceImpl's MemberServiceImpl()");
        bCryptPasswordEncoder = new BCryptPasswordEncoder();

        memberDao = MemberDaoImpl.getInstance();
        // sessionDao = SessionDaoImpl.getInstance();
        // SessionIdList = new ArrayList();
        //접속중인 sessionid를 session테이블에서 list로 저장
        // List<SessionDto> tmpList =sessionDao.SelectAll();
        // for(SessionDto dto : tmpList) {
        // 	SessionIdList.add(dto.getSessionId());
        // }
    }
    
    public List<MemberDto> getAllUsers() throws SQLException {
        return memberDao.selectAll();
    }

    @Override
    public boolean signUp(MemberDto dto) throws Exception {
        String encrypt = bCryptPasswordEncoder.encode(dto.getPassword());
        dto.setPassword(encrypt);

        return memberDao.insert(dto);
    }

    @Override
    public Map<String, Object> signIn(String username, String password, int SessiondId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }

    @Override
    public Map<String, Object> signOut(int SessionId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signOut'");
    }

    @Override
    public MemberDto getProfile(String username) throws Exception {
        return memberDao.select(username);
    }

    @Override
    public List<Integer> getSessionIdList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSessionIdList'");
    }
    
}
