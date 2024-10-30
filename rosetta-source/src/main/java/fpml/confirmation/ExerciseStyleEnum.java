package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ExerciseStyleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ExerciseStyleEnum")
public enum ExerciseStyleEnum {

	@RosettaEnumValue(value = "AMERICAN") 
	AMERICAN("AMERICAN", null),
	
	@RosettaEnumValue(value = "BERMUDA") 
	BERMUDA("BERMUDA", null),
	
	@RosettaEnumValue(value = "EUROPEAN") 
	EUROPEAN("EUROPEAN", null)
;
	private static Map<String, ExerciseStyleEnum> values;
	static {
        Map<String, ExerciseStyleEnum> map = new ConcurrentHashMap<>();
		for (ExerciseStyleEnum instance : ExerciseStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExerciseStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExerciseStyleEnum fromDisplayName(String name) {
		ExerciseStyleEnum value = values.get(name);
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
