package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ValuationMethodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ValuationMethodEnum")
public enum ValuationMethodEnum {

	@RosettaEnumValue(value = "MARKET") 
	MARKET("MARKET", null),
	
	@RosettaEnumValue(value = "HIGHEST") 
	HIGHEST("HIGHEST", null),
	
	@RosettaEnumValue(value = "AVERAGE_MARKET") 
	AVERAGE_MARKET("AVERAGE_MARKET", null),
	
	@RosettaEnumValue(value = "AVERAGE_HIGHEST") 
	AVERAGE_HIGHEST("AVERAGE_HIGHEST", null),
	
	@RosettaEnumValue(value = "BLENDED_MARKET") 
	BLENDED_MARKET("BLENDED_MARKET", null),
	
	@RosettaEnumValue(value = "BLENDED_HIGHEST") 
	BLENDED_HIGHEST("BLENDED_HIGHEST", null),
	
	@RosettaEnumValue(value = "AVERAGE_BLENDED_MARKET") 
	AVERAGE_BLENDED_MARKET("AVERAGE_BLENDED_MARKET", null),
	
	@RosettaEnumValue(value = "AVERAGE_BLENDED_HIGHEST") 
	AVERAGE_BLENDED_HIGHEST("AVERAGE_BLENDED_HIGHEST", null)
;
	private static Map<String, ValuationMethodEnum> values;
	static {
        Map<String, ValuationMethodEnum> map = new ConcurrentHashMap<>();
		for (ValuationMethodEnum instance : ValuationMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationMethodEnum fromDisplayName(String name) {
		ValuationMethodEnum value = values.get(name);
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
