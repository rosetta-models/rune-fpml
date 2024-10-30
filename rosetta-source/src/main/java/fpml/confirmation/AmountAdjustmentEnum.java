package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.AmountAdjustmentEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("AmountAdjustmentEnum")
public enum AmountAdjustmentEnum {

	@RosettaEnumValue(value = "DECREASE") 
	DECREASE("DECREASE", null),
	
	@RosettaEnumValue(value = "INCREASE") 
	INCREASE("INCREASE", null)
;
	private static Map<String, AmountAdjustmentEnum> values;
	static {
        Map<String, AmountAdjustmentEnum> map = new ConcurrentHashMap<>();
		for (AmountAdjustmentEnum instance : AmountAdjustmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AmountAdjustmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AmountAdjustmentEnum fromDisplayName(String name) {
		AmountAdjustmentEnum value = values.get(name);
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
