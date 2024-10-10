package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DifferenceTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DifferenceTypeEnum")
public enum DifferenceTypeEnum {

	@RosettaEnumValue(value = "VALUE") 
	VALUE("VALUE", null),
	
	@RosettaEnumValue(value = "REFERENCE") 
	REFERENCE("REFERENCE", null),
	
	@RosettaEnumValue(value = "STRUCTURE") 
	STRUCTURE("STRUCTURE", null),
	
	@RosettaEnumValue(value = "SCHEME") 
	SCHEME("SCHEME", null)
;
	private static Map<String, DifferenceTypeEnum> values;
	static {
        Map<String, DifferenceTypeEnum> map = new ConcurrentHashMap<>();
		for (DifferenceTypeEnum instance : DifferenceTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DifferenceTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DifferenceTypeEnum fromDisplayName(String name) {
		DifferenceTypeEnum value = values.get(name);
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
