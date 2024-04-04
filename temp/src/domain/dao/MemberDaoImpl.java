package domain.dao;

import java.sql.SQLException;
import java.util.List;

import domain.dto.MemberDto;

public class MemberDaoImpl extends CommonDao implements MemberDao {

    private static MemberDao instance ;
	public static MemberDao getInstance() throws Exception {
		if(instance==null)
			instance=new MemberDaoImpl();
		return instance;
	}
	
    private MemberDaoImpl() throws Exception {
        System.out.println("[DAO] MemberDaoImpl's INIT " + conn);

    }
    
    @Override
    public boolean insert(MemberDto dto) throws Exception {
        pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
        pstmt.setString(1, dto.getUsername());
        pstmt.setString(2, dto.getPassword());
        pstmt.setString(3, dto.getEmail());
        pstmt.setInt(4, dto.getPhone());
        int result = pstmt.executeUpdate();
        freeConnection(pstmt);
        return result > 0;
    }

    @Override
    public List<MemberDto> selectAll() throws SQLException {
        pstmt = conn.prepareStatement("select * from member");
        rs = pstmt.executeQuery();
        MemberDto dto = null;
        List<MemberDto> list = null;
        if (rs != null) {
            while (rs.next()) {
                dto = new MemberDto();
                dto.setUsername(rs.getString("username"));
                dto.setPassword(rs.getString("password"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getInt("phone"));
                list.add(dto);
            }
        }
        freeConnection(pstmt, rs);
        System.out.println(list);
        return list;
    }

    @Override
    public MemberDto select(String username) throws Exception {
        pstmt = conn.prepareStatement("select * from member where username=?");
        pstmt.setString(1, username);
        rs = pstmt.executeQuery();
        MemberDto dto = null;

        if(rs!=null) {
			if(rs.next()) {
				dto = new MemberDto();
				dto.setUsername(username);
                dto.setPassword(rs.getString("password"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getInt("phone"));
			}
		}
		freeConnection(pstmt,rs);
		return dto;
    }

    @Override
    public MemberDto update(String username, String password, String email, Integer phone) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String username) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
