package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DifferenceSeverityEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("DifferenceSeverityEnum")
public enum DifferenceSeverityEnum {

	@RosettaEnumValue(value = "WARNING") 
	WARNING("WARNING", null),
	
	@RosettaEnumValue(value = "ERROR") 
	ERROR("ERROR", null)
;
	private static Map<String, DifferenceSeverityEnum> values;
	static {
        Map<String, DifferenceSeverityEnum> map = new ConcurrentHashMap<>();
		for (DifferenceSeverityEnum instance : DifferenceSeverityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DifferenceSeverityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DifferenceSeverityEnum fromDisplayName(String name) {
		DifferenceSeverityEnum value = values.get(name);
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
