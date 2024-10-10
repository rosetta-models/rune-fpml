package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingSettlementTaskStatusEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list that defines the status of a settlement task.
 * @version ${project.version}
 */
@RosettaEnum("LoanTradingSettlementTaskStatusEnum")
public enum LoanTradingSettlementTaskStatusEnum {

	/**
	 * Loan Market Association (UK).
	 */
	@RosettaEnumValue(value = "ACTIVE") 
	ACTIVE("ACTIVE", null),
	
	/**
	 * The Loan Syndications and Trading Association (US).
	 */
	@RosettaEnumValue(value = "CLEARED") 
	CLEARED("CLEARED", null),
	
	@RosettaEnumValue(value = "CANCELLED") 
	CANCELLED("CANCELLED", null)
;
	private static Map<String, LoanTradingSettlementTaskStatusEnum> values;
	static {
        Map<String, LoanTradingSettlementTaskStatusEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingSettlementTaskStatusEnum instance : LoanTradingSettlementTaskStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingSettlementTaskStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingSettlementTaskStatusEnum fromDisplayName(String name) {
		LoanTradingSettlementTaskStatusEnum value = values.get(name);
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
