package foodbank.domain;

import java.time.LocalDateTime;

public class ConsumptionAllocated {
	private int consumptionRequestItemID;
	private String foodItem;
	private int consumptionRequestID;
	private String userName;
	private int quantity;
	private LocalDateTime updTime;
	private LocalDateTime updTimeEnd;
	public int getConsumptionRequestItemID() {
		return consumptionRequestItemID;
	}
	public void setConsumptionRequestItemID(int consumptionRequestItemID) {
		this.consumptionRequestItemID = consumptionRequestItemID;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public int getConsumptionRequestID() {
		return consumptionRequestID;
	}
	public void setConsumptionRequestID(int consumptionRequestID) {
		this.consumptionRequestID = consumptionRequestID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consumptionRequestID;
		result = prime * result + consumptionRequestItemID;
		result = prime * result + ((foodItem == null) ? 0 : foodItem.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((updTime == null) ? 0 : updTime.hashCode());
		result = prime * result + ((updTimeEnd == null) ? 0 : updTimeEnd.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (!(obj instanceof ConsumptionAllocated)) {
			return false;
		}
		ConsumptionAllocated other = (ConsumptionAllocated) obj;
		if (consumptionRequestID != other.consumptionRequestID) {
			return false;
		}
		if (consumptionRequestItemID != other.consumptionRequestItemID) {
			return false;
		}
		if (foodItem == null) {
			if (other.foodItem != null) {
				return false;
			}
		} else if (!foodItem.equals(other.foodItem)) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		if (updTime == null) {
			if (other.updTime != null) {
				return false;
			}
		} else if (!updTime.equals(other.updTime)) {
			return false;
		}
		if (updTimeEnd == null) {
			if (other.updTimeEnd != null) {
				return false;
			}
		} else if (!updTimeEnd.equals(other.updTimeEnd)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsumptionAllocated [consumptionRequestItemID=").append(consumptionRequestItemID)
				.append(", foodItem=").append(foodItem).append(", consumptionRequestID=").append(consumptionRequestID)
				.append(", userName=").append(userName).append(", quantity=").append(quantity).append(", updTime=")
				.append(updTime).append(", updTimeEnd=").append(updTimeEnd).append("]");
		return builder.toString();
	}
	
	
}
