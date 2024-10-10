package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ValuationTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ValuationTypeEnum")
public enum ValuationTypeEnum {

	@RosettaEnumValue(value = "MODEL") 
	MODEL("MODEL", null),
	
	@RosettaEnumValue(value = "MARKET") 
	MARKET("MARKET", null)
;
	private static Map<String, ValuationTypeEnum> values;
	static {
        Map<String, ValuationTypeEnum> map = new ConcurrentHashMap<>();
		for (ValuationTypeEnum instance : ValuationTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationTypeEnum fromDisplayName(String name) {
		ValuationTypeEnum value = values.get(name);
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
