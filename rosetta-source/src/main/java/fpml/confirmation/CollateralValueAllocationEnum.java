package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CollateralValueAllocationEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CollateralValueAllocationEnum")
public enum CollateralValueAllocationEnum {

	@RosettaEnumValue(value = "BUFFER") 
	BUFFER("BUFFER", null),
	
	@RosettaEnumValue(value = "FULL") 
	FULL("FULL", null),
	
	@RosettaEnumValue(value = "EXCESS_OVER_MARGIN") 
	EXCESS_OVER_MARGIN("EXCESS_OVER_MARGIN", null),
	
	@RosettaEnumValue(value = "MARGIN") 
	MARGIN("MARGIN", null)
;
	private static Map<String, CollateralValueAllocationEnum> values;
	static {
        Map<String, CollateralValueAllocationEnum> map = new ConcurrentHashMap<>();
		for (CollateralValueAllocationEnum instance : CollateralValueAllocationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CollateralValueAllocationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CollateralValueAllocationEnum fromDisplayName(String name) {
		CollateralValueAllocationEnum value = values.get(name);
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
