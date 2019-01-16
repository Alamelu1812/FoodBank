package foodbank.domain;

import java.time.LocalDateTime;

public class UserLogin {

	private int userId;

	private String email;

	private UserType userType;

	private String password;

	private LocalDateTime updTime;

	public UserLogin(int userId, String email, UserType userType, String password, LocalDateTime updTime) {
		this.userId = userId;
		this.email = email;
		this.userType = userType;
		this.password = password;
		this.updTime = updTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getUpdTime() {
		return updTime;
	}

	public void setUpdTime(LocalDateTime updTime) {
		this.updTime = updTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((updTime == null) ? 0 : updTime.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserLogin)) {
			return false;
		}
		UserLogin other = (UserLogin) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (updTime == null) {
			if (other.updTime != null) {
				return false;
			}
		} else if (!updTime.equals(other.updTime)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		if (userType != other.userType) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserLogin [userId=").append(userId).append(", email=").append(email).append(", userType=")
				.append(userType).append(", password=").append(password).append(", updTime=").append(updTime)
				.append("]");
		return builder.toString();
	}

}
