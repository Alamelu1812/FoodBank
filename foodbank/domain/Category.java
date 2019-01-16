package foodbank.domain;

import java.util.HashMap;
import java.util.Map;

public enum Category {

	BABY_FOOD("Baby Food", 1), BAKERY("Bakery", 2), CEREAL("Cereal", 3), DAIRY("Dairy", 4), FRUITS("Fruits", 5), GRAINS("Grains", 6), JUICES("Juices", 7), MEAT("Meat", 8), OTHERS("Others", 9), POULTRY("Poultry", 10), SEAFOOD("Seafood", 11), VEGETABLES("Vegetables", 12);

	private String description;

	private int categoryId;

	private static Map<Integer, String> categoryIdToDescMap = null;

	private static Map<String, Integer> categoryDescToIdMap = null;

	private Category(String description, int categoryId) {
		this.description = description;
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public static String getDescForId(int categoryId) {
		if (categoryIdToDescMap == null) {
			categoryIdToDescMap = new HashMap<>();
			for (Category category: Category.values()) {
				categoryIdToDescMap.put(category.getCategoryId(), category.getDescription());
			}
		}
		return categoryIdToDescMap.get(categoryId);
	}

	public static Integer getIdForDesc(String categoryDesc) {
		if (categoryDescToIdMap == null) {
			categoryDescToIdMap = new HashMap<>();
			for (Category category: Category.values()) {
				categoryDescToIdMap.put(category.getDescription(),category.getCategoryId());
			}
		}
		return categoryDescToIdMap.get(categoryDesc);
	}
}