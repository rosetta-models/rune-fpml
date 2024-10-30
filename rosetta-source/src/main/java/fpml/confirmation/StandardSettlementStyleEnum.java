package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.StandardSettlementStyleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("StandardSettlementStyleEnum")
public enum StandardSettlementStyleEnum {

	@RosettaEnumValue(value = "STANDARD") 
	STANDARD("STANDARD", null),
	
	@RosettaEnumValue(value = "NET") 
	NET("NET", null),
	
	@RosettaEnumValue(value = "STANDARD_AND_NET") 
	STANDARD_AND_NET("STANDARD_AND_NET", null)
;
	private static Map<String, StandardSettlementStyleEnum> values;
	static {
        Map<String, StandardSettlementStyleEnum> map = new ConcurrentHashMap<>();
		for (StandardSettlementStyleEnum instance : StandardSettlementStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	StandardSettlementStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static StandardSettlementStyleEnum fromDisplayName(String name) {
		StandardSettlementStyleEnum value = values.get(name);
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
