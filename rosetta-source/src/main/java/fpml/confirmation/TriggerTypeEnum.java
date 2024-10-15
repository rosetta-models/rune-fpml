package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.TriggerTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate.
 * @version ${project.version}
 */
@RosettaEnum("TriggerTypeEnum")
public enum TriggerTypeEnum {

	@RosettaEnumValue(value = "EQUAL_OR_LESS") 
	EQUAL_OR_LESS("EQUAL_OR_LESS", null),
	
	@RosettaEnumValue(value = "EQUAL_OR_GREATER") 
	EQUAL_OR_GREATER("EQUAL_OR_GREATER", null),
	
	@RosettaEnumValue(value = "EQUAL") 
	EQUAL("EQUAL", null),
	
	@RosettaEnumValue(value = "LESS") 
	LESS("LESS", null),
	
	@RosettaEnumValue(value = "GREATER") 
	GREATER("GREATER", null)
;
	private static Map<String, TriggerTypeEnum> values;
	static {
        Map<String, TriggerTypeEnum> map = new ConcurrentHashMap<>();
		for (TriggerTypeEnum instance : TriggerTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TriggerTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TriggerTypeEnum fromDisplayName(String name) {
		TriggerTypeEnum value = values.get(name);
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
