package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DayTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DayTypeEnum")
public enum DayTypeEnum {

	@RosettaEnumValue(value = "BUSINESS") 
	BUSINESS("BUSINESS", null),
	
	@RosettaEnumValue(value = "CALENDAR") 
	CALENDAR("CALENDAR", null),
	
	@RosettaEnumValue(value = "COMMODITY_BUSINESS") 
	COMMODITY_BUSINESS("COMMODITY_BUSINESS", null),
	
	@RosettaEnumValue(value = "CURRENCY_BUSINESS") 
	CURRENCY_BUSINESS("CURRENCY_BUSINESS", null),
	
	@RosettaEnumValue(value = "EXCHANGE_BUSINESS") 
	EXCHANGE_BUSINESS("EXCHANGE_BUSINESS", null),
	
	@RosettaEnumValue(value = "SCHEDULED_TRADING_DAY") 
	SCHEDULED_TRADING_DAY("SCHEDULED_TRADING_DAY", null)
;
	private static Map<String, DayTypeEnum> values;
	static {
        Map<String, DayTypeEnum> map = new ConcurrentHashMap<>();
		for (DayTypeEnum instance : DayTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DayTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DayTypeEnum fromDisplayName(String name) {
		DayTypeEnum value = values.get(name);
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
