package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ElectricityProductTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of electricity product.
 * @version ${project.version}
 */
@RosettaEnum("ElectricityProductTypeEnum")
public enum ElectricityProductTypeEnum {

	@RosettaEnumValue(value = "ELECTRICITY") 
	ELECTRICITY("ELECTRICITY", null)
;
	private static Map<String, ElectricityProductTypeEnum> values;
	static {
        Map<String, ElectricityProductTypeEnum> map = new ConcurrentHashMap<>();
		for (ElectricityProductTypeEnum instance : ElectricityProductTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ElectricityProductTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ElectricityProductTypeEnum fromDisplayName(String name) {
		ElectricityProductTypeEnum value = values.get(name);
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
