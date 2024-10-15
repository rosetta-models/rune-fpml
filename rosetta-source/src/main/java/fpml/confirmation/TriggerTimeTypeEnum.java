package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.TriggerTimeTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("TriggerTimeTypeEnum")
public enum TriggerTimeTypeEnum {

	@RosettaEnumValue(value = "CLOSING") 
	CLOSING("CLOSING", null),
	
	@RosettaEnumValue(value = "ANYTIME") 
	ANYTIME("ANYTIME", null)
;
	private static Map<String, TriggerTimeTypeEnum> values;
	static {
        Map<String, TriggerTimeTypeEnum> map = new ConcurrentHashMap<>();
		for (TriggerTimeTypeEnum instance : TriggerTimeTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TriggerTimeTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TriggerTimeTypeEnum fromDisplayName(String name) {
		TriggerTimeTypeEnum value = values.get(name);
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
