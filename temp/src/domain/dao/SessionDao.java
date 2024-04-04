package domain.dao;

import java.util.List;

import domain.dto.SessionDto;

public interface SessionDao {
    
	//SESSION용
	boolean Insert(SessionDto sessionDto) throws Exception;

	SessionDto Select(int sessiondId) throws Exception;

	SessionDto Select(String username) throws Exception;

	boolean Delete(int sessionId) throws Exception;

	//SELECTALL
	List<SessionDto> SelectAll() throws Exception;

}
