package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.RateTreatmentEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("RateTreatmentEnum")
public enum RateTreatmentEnum {

	@RosettaEnumValue(value = "BOND_EQUIVALENT_YIELD") 
	BOND_EQUIVALENT_YIELD("BOND_EQUIVALENT_YIELD", null),
	
	@RosettaEnumValue(value = "MONEY_MARKET_YIELD") 
	MONEY_MARKET_YIELD("MONEY_MARKET_YIELD", null)
;
	private static Map<String, RateTreatmentEnum> values;
	static {
        Map<String, RateTreatmentEnum> map = new ConcurrentHashMap<>();
		for (RateTreatmentEnum instance : RateTreatmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RateTreatmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RateTreatmentEnum fromDisplayName(String name) {
		RateTreatmentEnum value = values.get(name);
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
