package domain.dto;

public class SessionDto {
    private int sessionId;
    private String username;
    public SessionDto() {
    }
    public SessionDto(int sessionId, String username) {
        this.sessionId = sessionId;
        this.username = username;
    }
    public int getSessionId() {
        return sessionId;
    }
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "SessionDto [sessionId=" + sessionId + ", username=" + username + "]";
    }

    
}
