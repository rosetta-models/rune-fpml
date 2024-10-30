package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CommissionDenominationEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("CommissionDenominationEnum")
public enum CommissionDenominationEnum {

	@RosettaEnumValue(value = "BPS") 
	BPS("BPS", null),
	
	@RosettaEnumValue(value = "PERCENTAGE") 
	PERCENTAGE("PERCENTAGE", null),
	
	@RosettaEnumValue(value = "CENTS_PER_SHARE") 
	CENTS_PER_SHARE("CENTS_PER_SHARE", null),
	
	@RosettaEnumValue(value = "FIXED_AMOUNT") 
	FIXED_AMOUNT("FIXED_AMOUNT", null)
;
	private static Map<String, CommissionDenominationEnum> values;
	static {
        Map<String, CommissionDenominationEnum> map = new ConcurrentHashMap<>();
		for (CommissionDenominationEnum instance : CommissionDenominationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommissionDenominationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommissionDenominationEnum fromDisplayName(String name) {
		CommissionDenominationEnum value = values.get(name);
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
