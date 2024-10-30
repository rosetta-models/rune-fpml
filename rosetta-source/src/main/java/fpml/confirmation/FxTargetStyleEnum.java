package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxTargetStyleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the method for calculating the gain in the period where the Target Knock-Out event occurs (Exact, Exclusive, Inclusive).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("FxTargetStyleEnum")
public enum FxTargetStyleEnum {

	/**
	 * The gain for the knockout period is adjusted to yield a final accumulated value equal to the target level.
	 */
	@RosettaEnumValue(value = "EXACT") 
	EXACT("EXACT", null),
	
	/**
	 * The gain for the knockout period is adjusted to zero i.e. the target yields zero value in the final period.
	 */
	@RosettaEnumValue(value = "EXCLUSIVE") 
	EXCLUSIVE("EXCLUSIVE", null),
	
	/**
	 * The gain for the knockout period is equal to the whole benefit of the final fixing over spot i.e. the final accumulated value may exceed the target level.
	 */
	@RosettaEnumValue(value = "INCLUSIVE") 
	INCLUSIVE("INCLUSIVE", null)
;
	private static Map<String, FxTargetStyleEnum> values;
	static {
        Map<String, FxTargetStyleEnum> map = new ConcurrentHashMap<>();
		for (FxTargetStyleEnum instance : FxTargetStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxTargetStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxTargetStyleEnum fromDisplayName(String name) {
		FxTargetStyleEnum value = values.get(name);
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
