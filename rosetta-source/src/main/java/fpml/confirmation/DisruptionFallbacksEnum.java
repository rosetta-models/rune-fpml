package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DisruptionFallbacksEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of how disruption fallbacks will be represented.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("DisruptionFallbacksEnum")
public enum DisruptionFallbacksEnum {

	/**
	 * The Disruption Fallback(s) are determined by reference to the relevant Master Agreement.
	 */
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_MASTER_AGREEMENT") 
	AS_SPECIFIED_IN_MASTER_AGREEMENT("AS_SPECIFIED_IN_MASTER_AGREEMENT", null),
	
	/**
	 * The Disruption Fallback(s) are determined by reference to the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_CONFIRMATION") 
	AS_SPECIFIED_IN_CONFIRMATION("AS_SPECIFIED_IN_CONFIRMATION", null)
;
	private static Map<String, DisruptionFallbacksEnum> values;
	static {
        Map<String, DisruptionFallbacksEnum> map = new ConcurrentHashMap<>();
		for (DisruptionFallbacksEnum instance : DisruptionFallbacksEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DisruptionFallbacksEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DisruptionFallbacksEnum fromDisplayName(String name) {
		DisruptionFallbacksEnum value = values.get(name);
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
