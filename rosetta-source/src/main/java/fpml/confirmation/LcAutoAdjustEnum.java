package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LcAutoAdjustEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("LcAutoAdjustEnum")
public enum LcAutoAdjustEnum {

	@RosettaEnumValue(value = "AUTO_DECREASE") 
	AUTO_DECREASE("AUTO_DECREASE", null),
	
	@RosettaEnumValue(value = "AUTO_INCREASE") 
	AUTO_INCREASE("AUTO_INCREASE", null),
	
	@RosettaEnumValue(value = "AUTO_INCREASE_OR_DECREASE") 
	AUTO_INCREASE_OR_DECREASE("AUTO_INCREASE_OR_DECREASE", null)
;
	private static Map<String, LcAutoAdjustEnum> values;
	static {
        Map<String, LcAutoAdjustEnum> map = new ConcurrentHashMap<>();
		for (LcAutoAdjustEnum instance : LcAutoAdjustEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LcAutoAdjustEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LcAutoAdjustEnum fromDisplayName(String name) {
		LcAutoAdjustEnum value = values.get(name);
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
