package foodbank.domain;

import java.time.LocalDateTime;

public class Donation {

	private int donationID;
	private int donorID;
	private String preferredBeneficiary;
	private LocalDateTime appointmentTime;
	private String appointmentTimeString;
	private String frequency;
	private String comments;
	private LocalDateTime updTime;
	private LocalDateTime updTimeEnd;
	private String updTimeString;

	public int getDonationID() {
		return donationID;
	}
	public void setDonationID(int donationID) {
		this.donationID = donationID;
	}
	public int getDonorID() {
		return donorID;
	}
	public void setDonorID(int donorID) {
		this.donorID = donorID;
	}
	public String getPreferredBeneficiary() {
		return preferredBeneficiary;
	}
	public void setPreferredBeneficiary(String preferredBeneficiary) {
		this.preferredBeneficiary = preferredBeneficiary;
	}
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
		this.appointmentTimeString = appointmentTime == null? "" : appointmentTime.toString().replace('T', ' ');
	}
	public String getAppointmentTimeString() {
		return appointmentTimeString;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUpdTimeString() {
		return updTimeString;
	}
	public LocalDateTime getUpdTime() {
		return updTime;
	}
	public void setUpdTime(LocalDateTime updTime) {
		this.updTime = updTime;
		this.updTimeString = updTime == null ? "" : updTime.toString().replace('T', ' ');
	}
	public LocalDateTime getUpdTimeEnd() {
		return updTimeEnd;
	}
	public void setUpdTimeEnd(LocalDateTime updTimeEnd) {
		this.updTimeEnd = updTimeEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentTime == null) ? 0 : appointmentTime.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + donationID;
		result = prime * result + donorID;
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + preferredBeneficiary.hashCode();
		result = prime * result + ((updTime == null) ? 0 : updTime.hashCode());
		result = prime * result + ((updTimeEnd == null) ? 0 : updTimeEnd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donation other = (Donation) obj;
		if (appointmentTime == null) {
			if (other.appointmentTime != null)
				return false;
		} else if (!appointmentTime.equals(other.appointmentTime))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (donationID != other.donationID)
			return false;
		if (donorID != other.donorID)
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (preferredBeneficiary != other.preferredBeneficiary)
			return false;
		if (updTime == null) {
			if (other.updTime != null)
				return false;
		} else if (!updTime.equals(other.updTime))
			return false;
		if (updTimeEnd == null) {
			if (other.updTimeEnd != null)
				return false;
		} else if (!updTimeEnd.equals(other.updTimeEnd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Donation [donationID=" + donationID + ", donorID=" + donorID + ", preferredBeneficiary="
				+ preferredBeneficiary + ", appointmentTime=" + appointmentTime + ", frequency=" + frequency
				+ ", comments=" + comments + ", updTime=" + updTime + ", updTimeEnd=" + updTimeEnd + "]";
	}
	
}