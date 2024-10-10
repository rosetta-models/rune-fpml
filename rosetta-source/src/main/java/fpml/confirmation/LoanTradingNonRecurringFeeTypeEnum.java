package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingNonRecurringFeeTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list of accruing fee types associated with a facility.
 * @version ${project.version}
 */
@RosettaEnum("LoanTradingNonRecurringFeeTypeEnum")
public enum LoanTradingNonRecurringFeeTypeEnum {

	/**
	 * Calculated as a percentage of the global commitment amount of a facility.
	 */
	@RosettaEnumValue(value = "AMENDMENT") 
	AMENDMENT("AMENDMENT", null),
	
	@RosettaEnumValue(value = "CONSENT") 
	CONSENT("CONSENT", null),
	
	/**
	 * Calculated as a percentage of the unutilized portion of the facility.
	 */
	@RosettaEnumValue(value = "FACILITY") 
	FACILITY("FACILITY", null),
	
	/**
	 * An on-going (accrual) fee paid to the Issuing Bank for a Letter of Credit. This is separate from the basic Letter of Credit Fee paid to the lender group.
	 */
	@RosettaEnumValue(value = "FACILITY_EXENSION") 
	FACILITY_EXENSION("FACILITY_EXENSION", null),
	
	/**
	 * Calculated as a percentage of the utilized portion of the facility. This fee type is subject to banding rules – different portions of the utilization amount may be subject to different percentages.
	 */
	@RosettaEnumValue(value = "UPFRONT") 
	UPFRONT("UPFRONT", null),
	
	@RosettaEnumValue(value = "WAIVER") 
	WAIVER("WAIVER", null)
;
	private static Map<String, LoanTradingNonRecurringFeeTypeEnum> values;
	static {
        Map<String, LoanTradingNonRecurringFeeTypeEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingNonRecurringFeeTypeEnum instance : LoanTradingNonRecurringFeeTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingNonRecurringFeeTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingNonRecurringFeeTypeEnum fromDisplayName(String name) {
		LoanTradingNonRecurringFeeTypeEnum value = values.get(name);
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
