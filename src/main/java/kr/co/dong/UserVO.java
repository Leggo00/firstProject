package kr.co.dong;

import lombok.Data;

@Data
public class UserVO {
	private String userId;
	private String userName;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
	
}
