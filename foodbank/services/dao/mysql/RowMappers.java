package foodbank.services.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import foodbank.domain.Donation;
import foodbank.domain.DonationItem;
import foodbank.domain.ConsumptionRequest;
import foodbank.domain.ConsumptionRequestItem;
import foodbank.domain.ConsumptionHistory;
import foodbank.domain.ConsumptionAllocated;
import foodbank.domain.ActiveRequest;
import foodbank.domain.AvailableInventory;
import foodbank.domain.UserLogin;
import foodbank.domain.UserType;
import foodbank.exceptions.DataAccessException;

public class RowMappers {

	static interface RowMapper<T> {
		T mapRow(ResultSet resultSet, int rowNum) throws SQLException;
	}

	public static <T> List<T> mapAllRows(ResultSet resultSet, RowMapper<T> rowMapper) {
		List<T> result = new ArrayList<>();
		int rowNum = 1;
		try {
			while(resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet, rowNum++));
			}
			resultSet.close();
		} catch (SQLException e) {
			throw new DataAccessException("Failed to process result ", e);
		}
		return result;
	}

	public static <T> T mapFirstRow(ResultSet resultSet, RowMapper<T> rowMapper) {
		try {
			resultSet.next();
			T result = rowMapper.mapRow(resultSet, 1);
			resultSet.close();
			return result;
		} catch (SQLException e) {
			throw new DataAccessException("Failed to process result ", e);
		}
	}

	public static RowMapper<Integer> getIdMapper(String idColumnName) {
		return (ResultSet resultSet, int rowNum) -> resultSet.getInt(idColumnName);
	}

	public static RowMapper<UserLogin> USER_LOGIN_MAPPER = new RowMapper<UserLogin>() {

		@Override
		public UserLogin mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new UserLogin(resultSet.getInt("user_id"), resultSet.getString("email"), Enum.valueOf(UserType.class, resultSet.getString("user_type")), resultSet.getString("password"), null);
		}
	};

	public static RowMapper<String> USER_NAME_MAPPER = new RowMapper<String>() {
		@Override
		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return resultSet.getString("user_name");
		}
	};

	public static RowMapper<Donation> DONATION_MAPPER = new RowMapper<Donation>() {

		@Override
		public Donation mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Donation donation = new Donation();
			donation.setAppointmentTime(resultSet.getTimestamp("appointment_time").toLocalDateTime());
			donation.setComments(resultSet.getString("comments"));
			donation.setDonationID(resultSet.getInt("donation_id"));
			donation.setFrequency(resultSet.getString("frequency"));
			donation.setPreferredBeneficiary(resultSet.getString("preferred_beneficiary"));
			donation.setUpdTime(resultSet.getTimestamp("upd_time").toLocalDateTime());
			return donation;
		}
	};
	
	public static RowMapper<DonationItem>DONATION_ITEM_MAPPER = new RowMapper<DonationItem>() {

		@Override
		public DonationItem mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			DonationItem donationItem = new DonationItem();
			donationItem.setCategoryID(resultSet.getInt("category_id"));
			donationItem.setExpirationDate(resultSet.getDate("expiration_date").toLocalDate());
			donationItem.setFoodItem(resultSet.getString("food_item"));
			donationItem.setQuantity(resultSet.getInt("quantity"));
			donationItem.setUnits(resultSet.getString("units"));
			return donationItem;
		}
	};
	
	public static RowMapper<ConsumptionRequest> CONSUMPTION_REQUEST_MAPPER = new RowMapper<ConsumptionRequest>() {

		@Override
		public ConsumptionRequest mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ConsumptionRequest consumptionRequest = new ConsumptionRequest();
			consumptionRequest.setAppointmentTime(resultSet.getTimestamp("appointment_time").toLocalDateTime());
			consumptionRequest.setComments(resultSet.getString("comments"));
			consumptionRequest.setConsumerID(resultSet.getInt("consumer_id"));
			consumptionRequest.setConsumptionRequestID(resultSet.getInt("consumption_request_id"));
			consumptionRequest.setFrequency(resultSet.getString("frequency"));
			consumptionRequest.setPreferredBeneficiary(resultSet.getString("preferred_beneficiary"));
			consumptionRequest.setUpdTime(resultSet.getTimestamp("upd_time").toLocalDateTime());
			return consumptionRequest;
		}
	};

	public static RowMapper<ConsumptionRequestItem>CONSUMPTION_REQUEST_ITEM_MAPPER = new RowMapper<ConsumptionRequestItem>() {

		@Override
		public ConsumptionRequestItem mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ConsumptionRequestItem consumptionRequestItem = new ConsumptionRequestItem();
			consumptionRequestItem.setCategoryID(resultSet.getInt("category_id"));
			consumptionRequestItem.setExpirationDate(resultSet.getDate("expiration_date").toLocalDate());
			consumptionRequestItem.setFoodItem(resultSet.getString("food_item"));
			consumptionRequestItem.setQuantity(resultSet.getInt("quantity"));
			consumptionRequestItem.setUnits(resultSet.getString("units"));
			return consumptionRequestItem;
		}
	};
	
	public static RowMapper<ConsumptionHistory>CONSUMPTION_HISTORY_MAPPER = new RowMapper<ConsumptionHistory>() {

		@Override
		public ConsumptionHistory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ConsumptionHistory consumptionHistory = new ConsumptionHistory();
			consumptionHistory.setConsumerID(resultSet.getInt("consumer_id"));
			consumptionHistory.setConsumerName(resultSet.getString("user_name"));
			consumptionHistory.setConsumptionRequestID(resultSet.getInt("consumption_request_id"));
			consumptionHistory.setRequestedQuantity(resultSet.getInt("requested_quantity"));
			consumptionHistory.setFulfilledAmount(resultSet.getInt("fulfilled_amount"));
			consumptionHistory.setYtdRequestedQuantity(resultSet.getInt("ytd_requested_quantity"));
			consumptionHistory.setYtdFulfilledAmount(resultSet.getInt("ytd_fulfilled_amount"));
			consumptionHistory.setUpdTime(resultSet.getTimestamp("upd_time").toLocalDateTime());
			return consumptionHistory;
		}
	};
	
	public static RowMapper<ConsumptionAllocated>CONSUMPTION_ALLOCATED_MAPPER = new RowMapper<ConsumptionAllocated>() {

		@Override
		public ConsumptionAllocated mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ConsumptionAllocated consumptionAllocated = new ConsumptionAllocated();
			consumptionAllocated.setConsumptionRequestItemID(resultSet.getInt("consumption_request_item_id"));
			consumptionAllocated.setConsumptionRequestID(resultSet.getInt("consumption_request_id"));
			consumptionAllocated.setFoodItem(resultSet.getString("food_item"));
			consumptionAllocated.setUserName(resultSet.getString("user_name"));
			consumptionAllocated.setQuantity(resultSet.getInt("quantity"));
			consumptionAllocated.setUpdTime(resultSet.getTimestamp("upd_time").toLocalDateTime());
			return consumptionAllocated;
		}
	};
	
	public static RowMapper<AvailableInventory>AVAILABLE_INVENTORY_MAPPER = new RowMapper<AvailableInventory>() {

		@Override
		public AvailableInventory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			AvailableInventory availableInventory = new AvailableInventory();
			availableInventory.setAvailableInventoryId(resultSet.getInt("available_inventory_id"));
			availableInventory.setCategoryName(resultSet.getString("category"));
			availableInventory.setFoodItem(resultSet.getString("food_item"));
			availableInventory.setQuantity(resultSet.getInt("quantity"));
			availableInventory.setUnit(resultSet.getString("unit"));
			availableInventory.setUpdTime(resultSet.getTimestamp("upd_time").toLocalDateTime());
			availableInventory.setUpdTimeEnd(resultSet.getTimestamp("upd_time_end").toLocalDateTime());
			return availableInventory;
		}
	};
	
	public static RowMapper<Integer>RECIPIENT_ID_MAPPER = new RowMapper<Integer>() {

		@Override
		public Integer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Integer recipientID = new Integer(0);
			recipientID = resultSet.getInt("user_id");
			return recipientID;
		}
	};
	
	
	public static RowMapper<String>RECIPIENT_NAME_MAPPER = new RowMapper<String>() {

		@Override
		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			String recipientName = new String();
			recipientName = resultSet.getString("user_name");
			return recipientName;
		}
	};

	public static RowMapper<ActiveRequest> ACTIVE_REQUEST_MAPPER = new RowMapper<ActiveRequest>() {

		@Override
		public ActiveRequest mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ActiveRequest activeRequest = new ActiveRequest();
			activeRequest.setRecipientId(resultSet.getInt("user_id"));
			activeRequest.setRecipientName(resultSet.getString("user_name"));
			activeRequest.setQuantity(resultSet.getInt("quantity"));
			activeRequest.setUnits(resultSet.getString("units"));
			return activeRequest;
		}
	};
}
