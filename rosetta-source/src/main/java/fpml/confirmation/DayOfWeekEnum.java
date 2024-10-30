package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DayOfWeekEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A day of the seven-day week.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("DayOfWeekEnum")
public enum DayOfWeekEnum {

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
	SUN("SUN", null)
;
	private static Map<String, DayOfWeekEnum> values;
	static {
        Map<String, DayOfWeekEnum> map = new ConcurrentHashMap<>();
		for (DayOfWeekEnum instance : DayOfWeekEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DayOfWeekEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DayOfWeekEnum fromDisplayName(String name) {
		DayOfWeekEnum value = values.get(name);
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
