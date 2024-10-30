package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.TriggerConditionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("TriggerConditionEnum")
public enum TriggerConditionEnum {

	@RosettaEnumValue(value = "AT_OR_ABOVE") 
	AT_OR_ABOVE("AT_OR_ABOVE", null),
	
	@RosettaEnumValue(value = "AT_OR_BELOW") 
	AT_OR_BELOW("AT_OR_BELOW", null),
	
	@RosettaEnumValue(value = "ABOVE") 
	ABOVE("ABOVE", null),
	
	@RosettaEnumValue(value = "BELOW") 
	BELOW("BELOW", null)
;
	private static Map<String, TriggerConditionEnum> values;
	static {
        Map<String, TriggerConditionEnum> map = new ConcurrentHashMap<>();
		for (TriggerConditionEnum instance : TriggerConditionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TriggerConditionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TriggerConditionEnum fromDisplayName(String name) {
		TriggerConditionEnum value = values.get(name);
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
