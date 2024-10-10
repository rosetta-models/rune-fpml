package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.RoundingDirectionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The method of rounding a fractional number.
 * @version ${project.version}
 */
@RosettaEnum("RoundingDirectionEnum")
public enum RoundingDirectionEnum {

	@RosettaEnumValue(value = "UP") 
	UP("UP", null),
	
	@RosettaEnumValue(value = "DOWN") 
	DOWN("DOWN", null),
	
	@RosettaEnumValue(value = "NEAREST") 
	NEAREST("NEAREST", null)
;
	private static Map<String, RoundingDirectionEnum> values;
	static {
        Map<String, RoundingDirectionEnum> map = new ConcurrentHashMap<>();
		for (RoundingDirectionEnum instance : RoundingDirectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RoundingDirectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RoundingDirectionEnum fromDisplayName(String name) {
		RoundingDirectionEnum value = values.get(name);
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
