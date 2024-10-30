package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.OptionTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("OptionTypeEnum")
public enum OptionTypeEnum {

	@RosettaEnumValue(value = "PUT") 
	PUT("PUT", null),
	
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	@RosettaEnumValue(value = "PAYER") 
	PAYER("PAYER", null),
	
	@RosettaEnumValue(value = "RECEIVER") 
	RECEIVER("RECEIVER", null),
	
	@RosettaEnumValue(value = "STRADDLE") 
	STRADDLE("STRADDLE", null)
;
	private static Map<String, OptionTypeEnum> values;
	static {
        Map<String, OptionTypeEnum> map = new ConcurrentHashMap<>();
		for (OptionTypeEnum instance : OptionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionTypeEnum fromDisplayName(String name) {
		OptionTypeEnum value = values.get(name);
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
