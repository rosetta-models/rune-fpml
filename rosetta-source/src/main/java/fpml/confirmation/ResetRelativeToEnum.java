package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ResetRelativeToEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of whether resets occur relative to the first or last day of a calculation period.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ResetRelativeToEnum")
public enum ResetRelativeToEnum {

	@RosettaEnumValue(value = "CALCULATION_PERIOD_START_DATE") 
	CALCULATION_PERIOD_START_DATE("CALCULATION_PERIOD_START_DATE", null),
	
	@RosettaEnumValue(value = "CALCULATION_PERIOD_END_DATE") 
	CALCULATION_PERIOD_END_DATE("CALCULATION_PERIOD_END_DATE", null)
;
	private static Map<String, ResetRelativeToEnum> values;
	static {
        Map<String, ResetRelativeToEnum> map = new ConcurrentHashMap<>();
		for (ResetRelativeToEnum instance : ResetRelativeToEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ResetRelativeToEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ResetRelativeToEnum fromDisplayName(String name) {
		ResetRelativeToEnum value = values.get(name);
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
