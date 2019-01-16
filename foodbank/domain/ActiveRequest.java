package foodbank.domain;

public class ActiveRequest {

	private int recipientId;
	private String recipientName;
	private int quantity;
	private String units;
	
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		result = prime * result + recipientId;
		result = prime * result + ((recipientName == null) ? 0 : recipientName.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		if (!(obj instanceof ActiveRequest)) {
			return false;
		}
		ActiveRequest other = (ActiveRequest) obj;
		if (quantity != other.quantity) {
			return false;
		}
		if (recipientId != other.recipientId) {
			return false;
		}
		if (recipientName == null) {
			if (other.recipientName != null) {
				return false;
			}
		} else if (!recipientName.equals(other.recipientName)) {
			return false;
		}
		if (units == null) {
			if (other.units != null) {
				return false;
			}
		} else if (!units.equals(other.units)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActiveRequest [recipientId=").append(recipientId).append(", recipientName=")
				.append(recipientName).append(", quantity=").append(quantity).append(", units=").append(units)
				.append("]");
		return builder.toString();
	}
	
}
