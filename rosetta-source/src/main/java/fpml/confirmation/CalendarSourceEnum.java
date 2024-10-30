package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CalendarSourceEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("CalendarSourceEnum")
public enum CalendarSourceEnum {

	@RosettaEnumValue(value = "LISTED_OPTION") 
	LISTED_OPTION("LISTED_OPTION", null),
	
	@RosettaEnumValue(value = "FUTURE") 
	FUTURE("FUTURE", null)
;
	private static Map<String, CalendarSourceEnum> values;
	static {
        Map<String, CalendarSourceEnum> map = new ConcurrentHashMap<>();
		for (CalendarSourceEnum instance : CalendarSourceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CalendarSourceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CalendarSourceEnum fromDisplayName(String name) {
		CalendarSourceEnum value = values.get(name);
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
