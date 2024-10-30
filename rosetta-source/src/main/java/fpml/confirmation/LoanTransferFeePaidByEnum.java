package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTransferFeePaidByEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list of standard market rules for the treatment of split of assignment fees between counterparties.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("LoanTransferFeePaidByEnum")
public enum LoanTransferFeePaidByEnum {

	/**
	 * Buyer is responsible for one half of one allocation&#39;s assignment fee (regardless of the number of allocations).
	 */
	@RosettaEnumValue(value = "BUYER_SPLIT_ONE_HALF") 
	BUYER_SPLIT_ONE_HALF("BUYER_SPLIT_ONE_HALF", null),
	
	/**
	 * Buyer is responsible for one allocation&#39;s assignment fee (regardless of the number of allocations).
	 */
	@RosettaEnumValue(value = "ONE_FEE_PAID_BY_BUYER") 
	ONE_FEE_PAID_BY_BUYER("ONE_FEE_PAID_BY_BUYER", null),
	
	/**
	 * Seller is responsible for one allocation&#39;s assignment fee (regardless of the number of allocations).
	 */
	@RosettaEnumValue(value = "ONE_FEE_PAID_BY_SELLER") 
	ONE_FEE_PAID_BY_SELLER("ONE_FEE_PAID_BY_SELLER", null),
	
	/**
	 * Fee is paid by buyer.
	 */
	@RosettaEnumValue(value = "PAID_BY_BUYER") 
	PAID_BY_BUYER("PAID_BY_BUYER", null),
	
	/**
	 * Fee is paid by seller.
	 */
	@RosettaEnumValue(value = "PAID_BY_SELLER") 
	PAID_BY_SELLER("PAID_BY_SELLER", null),
	
	/**
	 * Seller is responsible for one half of one allocation&#39;s assignment fee (regardless of the number of allocations).
	 */
	@RosettaEnumValue(value = "SELLER_SPLIT_ONE_HALF") 
	SELLER_SPLIT_ONE_HALF("SELLER_SPLIT_ONE_HALF", null),
	
	/**
	 * Ticket owner is responsible for one allocation&#39;s assignment fee (regardless of the number of allocations).
	 */
	@RosettaEnumValue(value = "SPLIT_FULL") 
	SPLIT_FULL("SPLIT_FULL", null)
;
	private static Map<String, LoanTransferFeePaidByEnum> values;
	static {
        Map<String, LoanTransferFeePaidByEnum> map = new ConcurrentHashMap<>();
		for (LoanTransferFeePaidByEnum instance : LoanTransferFeePaidByEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTransferFeePaidByEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTransferFeePaidByEnum fromDisplayName(String name) {
		LoanTransferFeePaidByEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
