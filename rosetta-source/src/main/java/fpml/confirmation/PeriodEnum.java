package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PeriodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("PeriodEnum")
public enum PeriodEnum {

	@RosettaEnumValue(value = "D") 
	D("D", null),
	
	@RosettaEnumValue(value = "W") 
	W("W", null),
	
	@RosettaEnumValue(value = "M") 
	M("M", null),
	
	@RosettaEnumValue(value = "Y") 
	Y("Y", null)
;
	private static Map<String, PeriodEnum> values;
	static {
        Map<String, PeriodEnum> map = new ConcurrentHashMap<>();
		for (PeriodEnum instance : PeriodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PeriodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PeriodEnum fromDisplayName(String name) {
		PeriodEnum value = values.get(name);
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
