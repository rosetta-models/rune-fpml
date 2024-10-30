package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.InterestShortfallCapEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of the interest shortfall cap, applicable to mortgage derivatives.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("InterestShortfallCapEnum")
public enum InterestShortfallCapEnum {

	@RosettaEnumValue(value = "FIXED") 
	FIXED("FIXED", null),
	
	@RosettaEnumValue(value = "VARIABLE") 
	VARIABLE("VARIABLE", null)
;
	private static Map<String, InterestShortfallCapEnum> values;
	static {
        Map<String, InterestShortfallCapEnum> map = new ConcurrentHashMap<>();
		for (InterestShortfallCapEnum instance : InterestShortfallCapEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InterestShortfallCapEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InterestShortfallCapEnum fromDisplayName(String name) {
		InterestShortfallCapEnum value = values.get(name);
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
