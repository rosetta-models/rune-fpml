package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LengthUnitEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("LengthUnitEnum")
public enum LengthUnitEnum {

	@RosettaEnumValue(value = "PAGES") 
	PAGES("PAGES", null),
	
	@RosettaEnumValue(value = "TIME_UNIT") 
	TIME_UNIT("TIME_UNIT", null)
;
	private static Map<String, LengthUnitEnum> values;
	static {
        Map<String, LengthUnitEnum> map = new ConcurrentHashMap<>();
		for (LengthUnitEnum instance : LengthUnitEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LengthUnitEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LengthUnitEnum fromDisplayName(String name) {
		LengthUnitEnum value = values.get(name);
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
