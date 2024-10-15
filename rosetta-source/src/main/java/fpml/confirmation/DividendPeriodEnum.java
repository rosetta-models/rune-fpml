package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DividendPeriodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DividendPeriodEnum")
public enum DividendPeriodEnum {

	@RosettaEnumValue(value = "FIRST_PERIOD") 
	FIRST_PERIOD("FIRST_PERIOD", null),
	
	@RosettaEnumValue(value = "SECOND_PERIOD") 
	SECOND_PERIOD("SECOND_PERIOD", null)
;
	private static Map<String, DividendPeriodEnum> values;
	static {
        Map<String, DividendPeriodEnum> map = new ConcurrentHashMap<>();
		for (DividendPeriodEnum instance : DividendPeriodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendPeriodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendPeriodEnum fromDisplayName(String name) {
		DividendPeriodEnum value = values.get(name);
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
