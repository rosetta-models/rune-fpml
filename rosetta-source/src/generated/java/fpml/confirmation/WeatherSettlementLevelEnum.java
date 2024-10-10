package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.WeatherSettlementLevelEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("WeatherSettlementLevelEnum")
public enum WeatherSettlementLevelEnum {

	/**
	 * The cumulative number of Weather Index Units for each day in the Calculation Period.
	 */
	@RosettaEnumValue(value = "CUMULATIVE") 
	CUMULATIVE("CUMULATIVE", null),
	
	/**
	 * The cumulative number of Weather Index Units for each day in the Calculation Period divided by the number of days in the Calculation Period.
	 */
	@RosettaEnumValue(value = "AVERAGE") 
	AVERAGE("AVERAGE", null),
	
	/**
	 * The maximum number of Weather Index Units for any day in the Calculation Period.
	 */
	@RosettaEnumValue(value = "MXIMUM") 
	MXIMUM("MXIMUM", null),
	
	/**
	 * The minimum number of Weather Index Units for any day in the Calculation Period.
	 */
	@RosettaEnumValue(value = "MINIMUM") 
	MINIMUM("MINIMUM", null)
;
	private static Map<String, WeatherSettlementLevelEnum> values;
	static {
        Map<String, WeatherSettlementLevelEnum> map = new ConcurrentHashMap<>();
		for (WeatherSettlementLevelEnum instance : WeatherSettlementLevelEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	WeatherSettlementLevelEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static WeatherSettlementLevelEnum fromDisplayName(String name) {
		WeatherSettlementLevelEnum value = values.get(name);
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
