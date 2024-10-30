package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.MethodOfAdjustmentEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("MethodOfAdjustmentEnum")
public enum MethodOfAdjustmentEnum {

	@RosettaEnumValue(value = "CALCULATION_AGENT") 
	CALCULATION_AGENT("CALCULATION_AGENT", null),
	
	@RosettaEnumValue(value = "OPTIONS_EXCHANGE") 
	OPTIONS_EXCHANGE("OPTIONS_EXCHANGE", null)
;
	private static Map<String, MethodOfAdjustmentEnum> values;
	static {
        Map<String, MethodOfAdjustmentEnum> map = new ConcurrentHashMap<>();
		for (MethodOfAdjustmentEnum instance : MethodOfAdjustmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MethodOfAdjustmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MethodOfAdjustmentEnum fromDisplayName(String name) {
		MethodOfAdjustmentEnum value = values.get(name);
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
