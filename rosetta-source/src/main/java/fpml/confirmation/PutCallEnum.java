package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PutCallEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("PutCallEnum")
public enum PutCallEnum {

	@RosettaEnumValue(value = "PUT") 
	PUT("PUT", null),
	
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null)
;
	private static Map<String, PutCallEnum> values;
	static {
        Map<String, PutCallEnum> map = new ConcurrentHashMap<>();
		for (PutCallEnum instance : PutCallEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PutCallEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PutCallEnum fromDisplayName(String name) {
		PutCallEnum value = values.get(name);
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
