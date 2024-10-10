package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ShareExtraordinaryEventEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ShareExtraordinaryEventEnum")
public enum ShareExtraordinaryEventEnum {

	@RosettaEnumValue(value = "ALTERNATIVE_OBLIGATION") 
	ALTERNATIVE_OBLIGATION("ALTERNATIVE_OBLIGATION", null),
	
	@RosettaEnumValue(value = "CANCELLATION_AND_PAYMENT") 
	CANCELLATION_AND_PAYMENT("CANCELLATION_AND_PAYMENT", null),
	
	@RosettaEnumValue(value = "OPTIONS_EXCHANGE") 
	OPTIONS_EXCHANGE("OPTIONS_EXCHANGE", null),
	
	@RosettaEnumValue(value = "CALCULATION_AGENT") 
	CALCULATION_AGENT("CALCULATION_AGENT", null),
	
	@RosettaEnumValue(value = "MODIFIED_CALCULATION_AGENT") 
	MODIFIED_CALCULATION_AGENT("MODIFIED_CALCULATION_AGENT", null),
	
	@RosettaEnumValue(value = "PARTIAL_CANCELLATION_AND_PAYMENT") 
	PARTIAL_CANCELLATION_AND_PAYMENT("PARTIAL_CANCELLATION_AND_PAYMENT", null),
	
	@RosettaEnumValue(value = "COMPONENT") 
	COMPONENT("COMPONENT", null)
;
	private static Map<String, ShareExtraordinaryEventEnum> values;
	static {
        Map<String, ShareExtraordinaryEventEnum> map = new ConcurrentHashMap<>();
		for (ShareExtraordinaryEventEnum instance : ShareExtraordinaryEventEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ShareExtraordinaryEventEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ShareExtraordinaryEventEnum fromDisplayName(String name) {
		ShareExtraordinaryEventEnum value = values.get(name);
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
