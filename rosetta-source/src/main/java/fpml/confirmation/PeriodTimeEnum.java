package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PeriodTimeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of a time period containing additional values such as Term.
 * @version ${project.version}
 */
@RosettaEnum("PeriodTimeEnum")
public enum PeriodTimeEnum {

	@RosettaEnumValue(value = "D") 
	D("D", null),
	
	@RosettaEnumValue(value = "W") 
	W("W", null),
	
	@RosettaEnumValue(value = "M") 
	M("M", null),
	
	@RosettaEnumValue(value = "Y") 
	Y("Y", null),
	
	/**
	 * Period measured in hours.
	 */
	@RosettaEnumValue(value = "HOUR") 
	HOUR("HOUR", null),
	
	/**
	 * Period measured in minutes.
	 */
	@RosettaEnumValue(value = "MINUTE") 
	MINUTE("MINUTE", null),
	
	/**
	 * Period measured in seconds.
	 */
	@RosettaEnumValue(value = "SECOND") 
	SECOND("SECOND", null)
;
	private static Map<String, PeriodTimeEnum> values;
	static {
        Map<String, PeriodTimeEnum> map = new ConcurrentHashMap<>();
		for (PeriodTimeEnum instance : PeriodTimeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PeriodTimeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PeriodTimeEnum fromDisplayName(String name) {
		PeriodTimeEnum value = values.get(name);
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
