package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.InterpolationPeriodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines applicable periods for interpolation.
 * @version ${project.version}
 */
@RosettaEnum("InterpolationPeriodEnum")
public enum InterpolationPeriodEnum {

	/**
	 * Interpolation is applicable to the initial period only.
	 */
	@RosettaEnumValue(value = "INITIAL") 
	INITIAL("INITIAL", null),
	
	/**
	 * Interpolation is applicable to the initial and final periods only.
	 */
	@RosettaEnumValue(value = "INITIAL_AND_FINAL") 
	INITIAL_AND_FINAL("INITIAL_AND_FINAL", null),
	
	/**
	 * Interpolation is applicable to the final period only.
	 */
	@RosettaEnumValue(value = "FINAL") 
	FINAL("FINAL", null),
	
	/**
	 * Interpolation is applicable to any non-standard period.
	 */
	@RosettaEnumValue(value = "ANY_PERIOD") 
	ANY_PERIOD("ANY_PERIOD", null)
;
	private static Map<String, InterpolationPeriodEnum> values;
	static {
        Map<String, InterpolationPeriodEnum> map = new ConcurrentHashMap<>();
		for (InterpolationPeriodEnum instance : InterpolationPeriodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InterpolationPeriodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InterpolationPeriodEnum fromDisplayName(String name) {
		InterpolationPeriodEnum value = values.get(name);
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
