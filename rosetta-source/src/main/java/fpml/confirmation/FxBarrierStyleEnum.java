package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxBarrierStyleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the barrier observation style i.e. continuous (American) or discrete (Euriopean).
 * @version ${project.version}
 */
@RosettaEnum("FxBarrierStyleEnum")
public enum FxBarrierStyleEnum {

	/**
	 * The barrier is observed continuously through the observation period.
	 */
	@RosettaEnumValue(value = "AMERICAN") 
	AMERICAN("AMERICAN", null),
	
	/**
	 * The barrier is observed on a discrete expiry date, or (in the case of a multi-phase product) series of expiry dates.
	 */
	@RosettaEnumValue(value = "EUROPEAN") 
	EUROPEAN("EUROPEAN", null)
;
	private static Map<String, FxBarrierStyleEnum> values;
	static {
        Map<String, FxBarrierStyleEnum> map = new ConcurrentHashMap<>();
		for (FxBarrierStyleEnum instance : FxBarrierStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxBarrierStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxBarrierStyleEnum fromDisplayName(String name) {
		FxBarrierStyleEnum value = values.get(name);
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
