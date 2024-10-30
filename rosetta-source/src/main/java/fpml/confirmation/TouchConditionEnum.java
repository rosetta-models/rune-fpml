package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.TouchConditionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("TouchConditionEnum")
public enum TouchConditionEnum {

	@RosettaEnumValue(value = "TOUCH") 
	TOUCH("TOUCH", null),
	
	@RosettaEnumValue(value = "NOTOUCH") 
	NOTOUCH("NOTOUCH", null)
;
	private static Map<String, TouchConditionEnum> values;
	static {
        Map<String, TouchConditionEnum> map = new ConcurrentHashMap<>();
		for (TouchConditionEnum instance : TouchConditionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TouchConditionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TouchConditionEnum fromDisplayName(String name) {
		TouchConditionEnum value = values.get(name);
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
