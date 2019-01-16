package foodbank.domain;

import java.time.LocalDateTime;

public class ConsumptionHistory {
	private int consumerID;
	private String consumerName;
	private int consumptionRequestID;
	private int requestedQuantity;
	private int fulfilledAmount;
	private int ytdRequestedQuantity;
	private int ytdFulfilledAmount;
	private LocalDateTime updTime;
	private LocalDateTime updTimeEnd;
	@Override
	public String toString() {
		return "ConsumptionHistory [consumerID=" + consumerID + ", consumptionRequestID=" + consumptionRequestID
				+ ", requestedQuantity=" + requestedQuantity + ", fulfilledAmount=" + fulfilledAmount
				+ ", ytdRequestedQuantity=" + ytdRequestedQuantity + ", ytdFulfilledAmount=" + ytdFulfilledAmount
				+ ", updTime=" + updTime + ", updTimeEnd=" + updTimeEnd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consumerID;
		result = prime * result + consumptionRequestID;
		result = prime * result + fulfilledAmount;
		result = prime * result + requestedQuantity;
		result = prime * result + ((updTime == null) ? 0 : updTime.hashCode());
		result = prime * result + ((updTimeEnd == null) ? 0 : updTimeEnd.hashCode());
		result = prime * result + ytdFulfilledAmount;
		result = prime * result + ytdRequestedQuantity;
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
		ConsumptionHistory other = (ConsumptionHistory) obj;
		if (consumerID != other.consumerID)
			return false;
		if (consumptionRequestID != other.consumptionRequestID)
			return false;
		if (fulfilledAmount != other.fulfilledAmount)
			return false;
		if (requestedQuantity != other.requestedQuantity)
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
		if (ytdFulfilledAmount != other.ytdFulfilledAmount)
			return false;
		if (ytdRequestedQuantity != other.ytdRequestedQuantity)
			return false;
		return true;
	}
	public int getConsumerID() {
		return consumerID;
	}
	public void setConsumerID(int consumerID) {
		this.consumerID = consumerID;
	}
	public int getConsumptionRequestID() {
		return consumptionRequestID;
	}
	public void setConsumptionRequestID(int consumptionRequestID) {
		this.consumptionRequestID = consumptionRequestID;
	}
	public int getRequestedQuantity() {
		return requestedQuantity;
	}
	public void setRequestedQuantity(int requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}
	public int getFulfilledAmount() {
		return fulfilledAmount;
	}
	public void setFulfilledAmount(int fulfilledAmount) {
		this.fulfilledAmount = fulfilledAmount;
	}
	public int getYtdRequestedQuantity() {
		return ytdRequestedQuantity;
	}
	public void setYtdRequestedQuantity(int ytdRequestedQuantity) {
		this.ytdRequestedQuantity = ytdRequestedQuantity;
	}
	public int getYtdFulfilledAmount() {
		return ytdFulfilledAmount;
	}
	public void setYtdFulfilledAmount(int ytdFulfilledAmount) {
		this.ytdFulfilledAmount = ytdFulfilledAmount;
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
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

}
