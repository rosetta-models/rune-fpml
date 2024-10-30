package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.InterestCalculationMethodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines whether the agent bank is making an interest payment based on the lender pro-rata share at the end of the period (snapshot) or based on the lender position throughout the period.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("InterestCalculationMethodEnum")
public enum InterestCalculationMethodEnum {

	/**
	 * Agent bank is making an interest payment based on the lender&#39;s contract position throughout the interest payment period.
	 */
	@RosettaEnumValue(value = "CONTRACT_POSITION_THRU_PERIOD") 
	CONTRACT_POSITION_THRU_PERIOD("CONTRACT_POSITION_THRU_PERIOD", null),
	
	/**
	 * Agent bank is making an interest payment based on the lender pro-rata share snapshot at the time of payment.
	 */
	@RosettaEnumValue(value = "PRO_RATA_SHARE_SNAPSHOT") 
	PRO_RATA_SHARE_SNAPSHOT("PRO_RATA_SHARE_SNAPSHOT", null)
;
	private static Map<String, InterestCalculationMethodEnum> values;
	static {
        Map<String, InterestCalculationMethodEnum> map = new ConcurrentHashMap<>();
		for (InterestCalculationMethodEnum instance : InterestCalculationMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InterestCalculationMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InterestCalculationMethodEnum fromDisplayName(String name) {
		InterestCalculationMethodEnum value = values.get(name);
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
