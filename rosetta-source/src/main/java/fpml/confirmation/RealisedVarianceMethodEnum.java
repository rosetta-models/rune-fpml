package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.RealisedVarianceMethodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("RealisedVarianceMethodEnum")
public enum RealisedVarianceMethodEnum {

	@RosettaEnumValue(value = "PREVIOUS") 
	PREVIOUS("PREVIOUS", null),
	
	@RosettaEnumValue(value = "LAST") 
	LAST("LAST", null),
	
	@RosettaEnumValue(value = "BOTH") 
	BOTH("BOTH", null)
;
	private static Map<String, RealisedVarianceMethodEnum> values;
	static {
        Map<String, RealisedVarianceMethodEnum> map = new ConcurrentHashMap<>();
		for (RealisedVarianceMethodEnum instance : RealisedVarianceMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RealisedVarianceMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RealisedVarianceMethodEnum fromDisplayName(String name) {
		RealisedVarianceMethodEnum value = values.get(name);
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
