package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DayOfWeekExtEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A day of the seven-day week, plus codes for weekends and weekdays.
 * @version ${project.version}
 */
@RosettaEnum("DayOfWeekExtEnum")
public enum DayOfWeekExtEnum {

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
	
	@RosettaEnumValue(value = "WD") 
	WD("WD", null),
	
	@RosettaEnumValue(value = "WN") 
	WN("WN", null)
;
	private static Map<String, DayOfWeekExtEnum> values;
	static {
        Map<String, DayOfWeekExtEnum> map = new ConcurrentHashMap<>();
		for (DayOfWeekExtEnum instance : DayOfWeekExtEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DayOfWeekExtEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DayOfWeekExtEnum fromDisplayName(String name) {
		DayOfWeekExtEnum value = values.get(name);
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
