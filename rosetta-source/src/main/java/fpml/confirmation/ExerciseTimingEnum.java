package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ExerciseTimingEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ExerciseTimingEnum")
public enum ExerciseTimingEnum {

	@RosettaEnumValue(value = "IMMEDIATE") 
	IMMEDIATE("IMMEDIATE", null),
	
	@RosettaEnumValue(value = "ON_EXPIRATION") 
	ON_EXPIRATION("ON_EXPIRATION", null)
;
	private static Map<String, ExerciseTimingEnum> values;
	static {
        Map<String, ExerciseTimingEnum> map = new ConcurrentHashMap<>();
		for (ExerciseTimingEnum instance : ExerciseTimingEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExerciseTimingEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExerciseTimingEnum fromDisplayName(String name) {
		ExerciseTimingEnum value = values.get(name);
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
