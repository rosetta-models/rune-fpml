package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingAccrualSettlementEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list that defines how the interest accrued during the settlement period is calculated and paid.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("LoanTradingAccrualSettlementEnum")
public enum LoanTradingAccrualSettlementEnum {

	/**
	 * Trades flat.
	 */
	@RosettaEnumValue(value = "FLAT") 
	FLAT("FLAT", null),
	
	/**
	 * Settled with Accrued Interest: Interest accrued during the settlement period is paid at settlement.
	 */
	@RosettaEnumValue(value = "SETTLED_WITH_ACCRUED") 
	SETTLED_WITH_ACCRUED("SETTLED_WITH_ACCRUED", null),
	
	/**
	 * Settled without Accrued Interest: Interest accrued during for the settlement period is not paid at settlement.
	 */
	@RosettaEnumValue(value = "SETTLED_WITHOUT_ACCRUED") 
	SETTLED_WITHOUT_ACCRUED("SETTLED_WITHOUT_ACCRUED", null)
;
	private static Map<String, LoanTradingAccrualSettlementEnum> values;
	static {
        Map<String, LoanTradingAccrualSettlementEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingAccrualSettlementEnum instance : LoanTradingAccrualSettlementEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingAccrualSettlementEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingAccrualSettlementEnum fromDisplayName(String name) {
		LoanTradingAccrualSettlementEnum value = values.get(name);
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
