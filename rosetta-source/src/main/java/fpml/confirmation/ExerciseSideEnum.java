package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ExerciseSideEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ExerciseSideEnum")
public enum ExerciseSideEnum {

	@RosettaEnumValue(value = "PUT") 
	PUT("PUT", null),
	
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	@RosettaEnumValue(value = "PAYER") 
	PAYER("PAYER", null),
	
	@RosettaEnumValue(value = "RECEIVER") 
	RECEIVER("RECEIVER", null)
;
	private static Map<String, ExerciseSideEnum> values;
	static {
        Map<String, ExerciseSideEnum> map = new ConcurrentHashMap<>();
		for (ExerciseSideEnum instance : ExerciseSideEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExerciseSideEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExerciseSideEnum fromDisplayName(String name) {
		ExerciseSideEnum value = values.get(name);
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
