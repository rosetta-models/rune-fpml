package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxAveragingMethodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Average calculation method e.g. Arithmetic, Harmonic)
 * @version ${project.version}
 */
@RosettaEnum("FxAveragingMethodEnum")
public enum FxAveragingMethodEnum {

	/**
	 * Arithmetic method of average calculation.
	 */
	@RosettaEnumValue(value = "ARITHMETIC") 
	ARITHMETIC("ARITHMETIC", null),
	
	/**
	 * Harmonic method of average calculation.
	 */
	@RosettaEnumValue(value = "HARMONIC") 
	HARMONIC("HARMONIC", null)
;
	private static Map<String, FxAveragingMethodEnum> values;
	static {
        Map<String, FxAveragingMethodEnum> map = new ConcurrentHashMap<>();
		for (FxAveragingMethodEnum instance : FxAveragingMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxAveragingMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxAveragingMethodEnum fromDisplayName(String name) {
		FxAveragingMethodEnum value = values.get(name);
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
