package foodbank.services.dao.mysql;

import java.util.concurrent.atomic.AtomicInteger;

public class FoodBankSequenceSeedHome extends MySqlDAO {

	private static FoodBankSequenceSeedHome sequenceSeedHome = null;

	private AtomicInteger userInfoSeed;

	private AtomicInteger donationSeed;

	private AtomicInteger donationItemSeed;
	
	private AtomicInteger consumptionRequestSeed;

	private AtomicInteger consumptionRequestItemSeed;

	private AtomicInteger pendingConsumptionRequestItemSeed;

	private AtomicInteger availableInventorySeed;

	public FoodBankSequenceSeedHome(String host, String port, String database, String user, String password) {
		super(host, port, database, user, password);
		userInfoSeed = new AtomicInteger(getTableSeed("user_info", "user_id"));
		donationSeed = new AtomicInteger(getTableSeed("donation", "donation_id"));
		donationItemSeed = new AtomicInteger(getTableSeed("donation_item", "donation_item_id"));
		consumptionRequestSeed = new AtomicInteger(getTableSeed("consumption_request", "consumption_request_id"));
		consumptionRequestItemSeed = new AtomicInteger(getTableSeed("consumption_request_item", "consumption_request_item_id"));
		pendingConsumptionRequestItemSeed = new AtomicInteger(getTableSeed("pending_consumption_request_item", "pending_consumption_request_item_id"));
		availableInventorySeed = new AtomicInteger(getTableSeed("available_inventory", "available_inventory_id"));
	}

	private int getTableSeed(String tableName, String idColumnName) {
		return RowMappers.mapFirstRow(executeQuery("SELECT coalesce(max(" + idColumnName + "), 0) as " + idColumnName + " FROM " + tableName), RowMappers.getIdMapper(idColumnName));
	}

	public static FoodBankSequenceSeedHome getInstance(String host, String port, String database, String user, String password) {
		if (sequenceSeedHome != null) {
			return sequenceSeedHome;
		}
		synchronized (FoodBankSequenceSeedHome.class) {
			if (sequenceSeedHome == null) {
				sequenceSeedHome = new FoodBankSequenceSeedHome(host, port, database, user, password);
			}
		}
		return sequenceSeedHome;
	}

	public int getUserInfoSeed() {
		return userInfoSeed.incrementAndGet();
	}

	public int getDonationSeed() {
		return donationSeed.incrementAndGet();
	}

	public int getDonationItemSeed() {
		return donationItemSeed.incrementAndGet();
	}
	
	public int getConsumptionRequestSeed() {
		return consumptionRequestSeed.incrementAndGet();
	}

	public int getConsumptionRequestItemSeed() {
		return consumptionRequestItemSeed.incrementAndGet();
	}

	public int getPendingConsumptionRequestItemSeed() {
		return pendingConsumptionRequestItemSeed.incrementAndGet();
	}

	public int getAvailableInventorySeed() {
		return availableInventorySeed.incrementAndGet();
	}

}
