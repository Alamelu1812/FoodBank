package foodbank.domain;

import java.time.LocalDateTime;

public class UserInfo {

	private int userId;
	private String email;
	private String password;
	private String userName;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phoneNumber;
	private String userDescription;
	private UserType userType;
	private String transportationMethod;
	private int population;
	private LocalDateTime updTime;

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getTransportationMethod() {
		return transportationMethod;
	}
	public void setTransportationMethod(String transportationMethod) {
		this.transportationMethod = transportationMethod;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
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
		result = prime * result + ((addressLine == null) ? 0 : addressLine.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + population;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((transportationMethod == null) ? 0 : transportationMethod.hashCode());
		result = prime * result + ((updTime == null) ? 0 : updTime.hashCode());
		result = prime * result + ((userDescription == null) ? 0 : userDescription.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		if (!(obj instanceof UserInfo)) {
			return false;
		}
		UserInfo other = (UserInfo) obj;
		if (addressLine == null) {
			if (other.addressLine != null) {
				return false;
			}
		} else if (!addressLine.equals(other.addressLine)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
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
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (population != other.population) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (transportationMethod == null) {
			if (other.transportationMethod != null) {
				return false;
			}
		} else if (!transportationMethod.equals(other.transportationMethod)) {
			return false;
		}
		if (updTime == null) {
			if (other.updTime != null) {
				return false;
			}
		} else if (!updTime.equals(other.updTime)) {
			return false;
		}
		if (userDescription == null) {
			if (other.userDescription != null) {
				return false;
			}
		} else if (!userDescription.equals(other.userDescription)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userType != other.userType) {
			return false;
		}
		if (zipCode == null) {
			if (other.zipCode != null) {
				return false;
			}
		} else if (!zipCode.equals(other.zipCode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfo [userId=").append(userId).append(", email=").append(email).append(", userName=")
				.append(userName).append(", addressLine=").append(addressLine).append(", city=").append(city)
				.append(", state=").append(state).append(", country=").append(country).append(", zipCode=")
				.append(zipCode).append(", phoneNumber=").append(phoneNumber).append(", userDescription=")
				.append(userDescription).append(", userType=").append(userType).append(", transportationMethod=")
				.append(transportationMethod).append(", population=").append(population).append(", updTime=")
				.append(updTime).append("]");
		return builder.toString();
	}
}
