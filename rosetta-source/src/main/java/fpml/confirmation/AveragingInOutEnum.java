package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.AveragingInOutEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("AveragingInOutEnum")
public enum AveragingInOutEnum {

	@RosettaEnumValue(value = "IN") 
	IN("IN", null),
	
	@RosettaEnumValue(value = "OUT") 
	OUT("OUT", null),
	
	@RosettaEnumValue(value = "BOTH") 
	BOTH("BOTH", null)
;
	private static Map<String, AveragingInOutEnum> values;
	static {
        Map<String, AveragingInOutEnum> map = new ConcurrentHashMap<>();
		for (AveragingInOutEnum instance : AveragingInOutEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AveragingInOutEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AveragingInOutEnum fromDisplayName(String name) {
		AveragingInOutEnum value = values.get(name);
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
