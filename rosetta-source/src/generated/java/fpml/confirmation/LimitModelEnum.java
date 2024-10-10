package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LimitModelEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of credit approval request.
 * @version ${project.version}
 */
@RosettaEnum("LimitModelEnum")
public enum LimitModelEnum {

	@RosettaEnumValue(value = "PING") 
	PING("PING", null),
	
	@RosettaEnumValue(value = "PLUS1_TO_STOP") 
	PLUS1_TO_STOP("PLUS1_TO_STOP", null),
	
	@RosettaEnumValue(value = "PLUS1_TO_PING") 
	PLUS1_TO_PING("PLUS1_TO_PING", null),
	
	@RosettaEnumValue(value = "PUSH_TO_PING") 
	PUSH_TO_PING("PUSH_TO_PING", null),
	
	@RosettaEnumValue(value = "PUSH_TO_STOP") 
	PUSH_TO_STOP("PUSH_TO_STOP", null)
;
	private static Map<String, LimitModelEnum> values;
	static {
        Map<String, LimitModelEnum> map = new ConcurrentHashMap<>();
		for (LimitModelEnum instance : LimitModelEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LimitModelEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LimitModelEnum fromDisplayName(String name) {
		LimitModelEnum value = values.get(name);
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
