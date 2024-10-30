package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PayRelativeToEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of whether payments occur relative to the calculation period start or end date, or the reset date.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("PayRelativeToEnum")
public enum PayRelativeToEnum {

	@RosettaEnumValue(value = "CALCULATION_PERIOD_START_DATE") 
	CALCULATION_PERIOD_START_DATE("CALCULATION_PERIOD_START_DATE", null),
	
	@RosettaEnumValue(value = "CALCULATION_PERIOD_END_DATE") 
	CALCULATION_PERIOD_END_DATE("CALCULATION_PERIOD_END_DATE", null),
	
	@RosettaEnumValue(value = "LAST_PRICING_DATE") 
	LAST_PRICING_DATE("LAST_PRICING_DATE", null),
	
	@RosettaEnumValue(value = "RESET_DATE") 
	RESET_DATE("RESET_DATE", null),
	
	@RosettaEnumValue(value = "VALUATION_DATE") 
	VALUATION_DATE("VALUATION_DATE", null)
;
	private static Map<String, PayRelativeToEnum> values;
	static {
        Map<String, PayRelativeToEnum> map = new ConcurrentHashMap<>();
		for (PayRelativeToEnum instance : PayRelativeToEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PayRelativeToEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PayRelativeToEnum fromDisplayName(String name) {
		PayRelativeToEnum value = values.get(name);
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
