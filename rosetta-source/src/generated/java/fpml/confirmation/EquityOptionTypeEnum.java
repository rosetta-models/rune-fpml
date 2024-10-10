package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.EquityOptionTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("EquityOptionTypeEnum")
public enum EquityOptionTypeEnum {

	@RosettaEnumValue(value = "PUT") 
	PUT("PUT", null),
	
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	@RosettaEnumValue(value = "FORWARD") 
	FORWARD("FORWARD", null)
;
	private static Map<String, EquityOptionTypeEnum> values;
	static {
        Map<String, EquityOptionTypeEnum> map = new ConcurrentHashMap<>();
		for (EquityOptionTypeEnum instance : EquityOptionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EquityOptionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EquityOptionTypeEnum fromDisplayName(String name) {
		EquityOptionTypeEnum value = values.get(name);
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
