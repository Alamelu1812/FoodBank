package foodbank.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AvailableInventory {
	private int availableInventoryId;
	private String categoryName;
	private String foodItem;
	private int quantity;
	private LocalDateTime updTime;
	private LocalDateTime updTimeEnd;
	private String unit;
	private List<ActiveRequest> activeRequest = new ArrayList<>();

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
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
	public int getAvailableInventoryId() {
		return availableInventoryId;
	}
	public void setAvailableInventoryId(int availableInventoryId) {
		this.availableInventoryId = availableInventoryId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableInventoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((foodItem == null) ? 0 : foodItem.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((updTime == null) ? 0 : updTime.hashCode());
		result = prime * result + ((updTimeEnd == null) ? 0 : updTimeEnd.hashCode());
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
		if (!(obj instanceof AvailableInventory)) {
			return false;
		}
		AvailableInventory other = (AvailableInventory) obj;
		if (availableInventoryId != other.availableInventoryId) {
			return false;
		}
		if (categoryName == null) {
			if (other.categoryName != null) {
				return false;
			}
		} else if (!categoryName.equals(other.categoryName)) {
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
		if (unit == null) {
			if (other.unit != null) {
				return false;
			}
		} else if (!unit.equals(other.unit)) {
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AvailableInventory [availableInventoryId=").append(availableInventoryId)
				.append(", categoryName=").append(categoryName).append(", foodItem=").append(foodItem)
				.append(", quantity=").append(quantity).append(", updTime=").append(updTime).append(", updTimeEnd=")
				.append(updTimeEnd).append(", unit=").append(unit).append("]");
		return builder.toString();
	}
	public List<ActiveRequest> getActiveRequest() {
		return activeRequest;
	}
	public void setActiveRequest(List<ActiveRequest> activeRequest) {
		this.activeRequest = activeRequest;
	}
}
