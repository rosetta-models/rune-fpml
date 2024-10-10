package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CompoundingMethodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CompoundingMethodEnum")
public enum CompoundingMethodEnum {

	@RosettaEnumValue(value = "FLAT") 
	FLAT("FLAT", null),
	
	@RosettaEnumValue(value = "NONE") 
	NONE("NONE", null),
	
	@RosettaEnumValue(value = "STRAIGHT") 
	STRAIGHT("STRAIGHT", null),
	
	@RosettaEnumValue(value = "SPREAD_EXCLUSIVE") 
	SPREAD_EXCLUSIVE("SPREAD_EXCLUSIVE", null)
;
	private static Map<String, CompoundingMethodEnum> values;
	static {
        Map<String, CompoundingMethodEnum> map = new ConcurrentHashMap<>();
		for (CompoundingMethodEnum instance : CompoundingMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CompoundingMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CompoundingMethodEnum fromDisplayName(String name) {
		CompoundingMethodEnum value = values.get(name);
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
