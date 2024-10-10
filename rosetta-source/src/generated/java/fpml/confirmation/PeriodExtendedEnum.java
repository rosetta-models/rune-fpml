package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PeriodExtendedEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("PeriodExtendedEnum")
public enum PeriodExtendedEnum {

	@RosettaEnumValue(value = "D") 
	D("D", null),
	
	@RosettaEnumValue(value = "W") 
	W("W", null),
	
	@RosettaEnumValue(value = "M") 
	M("M", null),
	
	@RosettaEnumValue(value = "Y") 
	Y("Y", null),
	
	@RosettaEnumValue(value = "T") 
	T("T", null)
;
	private static Map<String, PeriodExtendedEnum> values;
	static {
        Map<String, PeriodExtendedEnum> map = new ConcurrentHashMap<>();
		for (PeriodExtendedEnum instance : PeriodExtendedEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PeriodExtendedEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PeriodExtendedEnum fromDisplayName(String name) {
		PeriodExtendedEnum value = values.get(name);
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
