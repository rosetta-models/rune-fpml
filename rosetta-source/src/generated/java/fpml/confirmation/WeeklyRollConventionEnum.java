package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.WeeklyRollConventionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of a weekly roll day.
 * @version ${project.version}
 */
@RosettaEnum("WeeklyRollConventionEnum")
public enum WeeklyRollConventionEnum {

	@RosettaEnumValue(value = "MON") 
	MON("MON", null),
	
	@RosettaEnumValue(value = "TUE") 
	TUE("TUE", null),
	
	@RosettaEnumValue(value = "WED") 
	WED("WED", null),
	
	@RosettaEnumValue(value = "THU") 
	THU("THU", null),
	
	@RosettaEnumValue(value = "FRI") 
	FRI("FRI", null),
	
	@RosettaEnumValue(value = "SAT") 
	SAT("SAT", null),
	
	@RosettaEnumValue(value = "SUN") 
	SUN("SUN", null),
	
	@RosettaEnumValue(value = "TBILL") 
	TBILL("TBILL", null)
;
	private static Map<String, WeeklyRollConventionEnum> values;
	static {
        Map<String, WeeklyRollConventionEnum> map = new ConcurrentHashMap<>();
		for (WeeklyRollConventionEnum instance : WeeklyRollConventionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	WeeklyRollConventionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static WeeklyRollConventionEnum fromDisplayName(String name) {
		WeeklyRollConventionEnum value = values.get(name);
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
