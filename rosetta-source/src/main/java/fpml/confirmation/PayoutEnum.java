package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PayoutEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("PayoutEnum")
public enum PayoutEnum {

	@RosettaEnumValue(value = "DEFERRED") 
	DEFERRED("DEFERRED", null),
	
	@RosettaEnumValue(value = "IMMEDIATE") 
	IMMEDIATE("IMMEDIATE", null)
;
	private static Map<String, PayoutEnum> values;
	static {
        Map<String, PayoutEnum> map = new ConcurrentHashMap<>();
		for (PayoutEnum instance : PayoutEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PayoutEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PayoutEnum fromDisplayName(String name) {
		PayoutEnum value = values.get(name);
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
