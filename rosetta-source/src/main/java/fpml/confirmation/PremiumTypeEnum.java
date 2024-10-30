package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PremiumTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("PremiumTypeEnum")
public enum PremiumTypeEnum {

	@RosettaEnumValue(value = "PRE_PAID") 
	PRE_PAID("PRE_PAID", null),
	
	@RosettaEnumValue(value = "POST_PAID") 
	POST_PAID("POST_PAID", null),
	
	@RosettaEnumValue(value = "VARIABLE") 
	VARIABLE("VARIABLE", null),
	
	@RosettaEnumValue(value = "FIXED") 
	FIXED("FIXED", null)
;
	private static Map<String, PremiumTypeEnum> values;
	static {
        Map<String, PremiumTypeEnum> map = new ConcurrentHashMap<>();
		for (PremiumTypeEnum instance : PremiumTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PremiumTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PremiumTypeEnum fromDisplayName(String name) {
		PremiumTypeEnum value = values.get(name);
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
