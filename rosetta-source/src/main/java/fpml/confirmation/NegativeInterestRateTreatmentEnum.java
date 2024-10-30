package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.NegativeInterestRateTreatmentEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("NegativeInterestRateTreatmentEnum")
public enum NegativeInterestRateTreatmentEnum {

	@RosettaEnumValue(value = "NEGATIVE_INTEREST_RATE_METHOD") 
	NEGATIVE_INTEREST_RATE_METHOD("NEGATIVE_INTEREST_RATE_METHOD", null),
	
	@RosettaEnumValue(value = "ZERO_INTEREST_RATE_METHOD") 
	ZERO_INTEREST_RATE_METHOD("ZERO_INTEREST_RATE_METHOD", null)
;
	private static Map<String, NegativeInterestRateTreatmentEnum> values;
	static {
        Map<String, NegativeInterestRateTreatmentEnum> map = new ConcurrentHashMap<>();
		for (NegativeInterestRateTreatmentEnum instance : NegativeInterestRateTreatmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NegativeInterestRateTreatmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NegativeInterestRateTreatmentEnum fromDisplayName(String name) {
		NegativeInterestRateTreatmentEnum value = values.get(name);
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
