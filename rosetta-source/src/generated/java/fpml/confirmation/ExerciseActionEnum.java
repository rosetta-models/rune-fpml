package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ExerciseActionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ExerciseActionEnum")
public enum ExerciseActionEnum {

	@RosettaEnumValue(value = "FULL_EXERCISE") 
	FULL_EXERCISE("FULL_EXERCISE", null),
	
	@RosettaEnumValue(value = "PARTIAL_EXERCISE") 
	PARTIAL_EXERCISE("PARTIAL_EXERCISE", null),
	
	@RosettaEnumValue(value = "ABANDON") 
	ABANDON("ABANDON", null)
;
	private static Map<String, ExerciseActionEnum> values;
	static {
        Map<String, ExerciseActionEnum> map = new ConcurrentHashMap<>();
		for (ExerciseActionEnum instance : ExerciseActionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExerciseActionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExerciseActionEnum fromDisplayName(String name) {
		ExerciseActionEnum value = values.get(name);
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
