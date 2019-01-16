package foodbank.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DonationItem {
	
	private int donationItemID;
	private int donationID;
	private int categoryID;
	private String foodItem;
	private String units;
	private int quantity;
	private LocalDate expirationDate;
	private LocalDateTime updTime;
	private LocalDateTime updTimeEnd;

	public int getDonationItemID() {
		return donationItemID;
	}
	public void setDonationItemID(int donationItemID) {
		this.donationItemID = donationItemID;
	}
	public int getDonationID() {
		return donationID;
	}
	public void setDonationID(int donationID) {
		this.donationID = donationID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public LocalDateTime getUpdTime() {
		return updTime;
	}
	public void setUpdTime(LocalDateTime updTime) {
		this.updTime = updTime;
	}
	public LocalDateTime getUpdTimeEnd() {
		return updTimeEnd;
	}
	public void setUpdTimeEnd(LocalDateTime updTimeEnd) {
		this.updTimeEnd = updTimeEnd;
	}

	@Override
	public String toString() {
		return "DonationItem [donationItemID=" + donationItemID + ", donationID=" + donationID + ", categoryID="
				+ categoryID + ", foodItem=" + foodItem + ", units=" + units + ", quantity=" + quantity
				+ ", expirationDate=" + expirationDate + ", updTime=" + updTime
				+ ", updTimeEnd=" + updTimeEnd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryID;
		result = prime * result + donationID;
		result = prime * result + donationItemID;
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((foodItem == null) ? 0 : foodItem.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		DonationItem other = (DonationItem) obj;
		if (categoryID != other.categoryID)
			return false;
		if (donationID != other.donationID)
			return false;
		if (donationItemID != other.donationItemID)
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (foodItem == null) {
			if (other.foodItem != null)
				return false;
		} else if (!foodItem.equals(other.foodItem))
			return false;
		if (quantity != other.quantity)
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
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
}
