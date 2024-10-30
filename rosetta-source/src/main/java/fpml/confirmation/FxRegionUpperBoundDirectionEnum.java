package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxRegionUpperBoundDirectionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The Upper Bound Direction. It only contains the AtOrBelow and Below values.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("FxRegionUpperBoundDirectionEnum")
public enum FxRegionUpperBoundDirectionEnum {

	@RosettaEnumValue(value = "AT_OR_BELOW") 
	AT_OR_BELOW("AT_OR_BELOW", null),
	
	@RosettaEnumValue(value = "BELOW") 
	BELOW("BELOW", null)
;
	private static Map<String, FxRegionUpperBoundDirectionEnum> values;
	static {
        Map<String, FxRegionUpperBoundDirectionEnum> map = new ConcurrentHashMap<>();
		for (FxRegionUpperBoundDirectionEnum instance : FxRegionUpperBoundDirectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxRegionUpperBoundDirectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxRegionUpperBoundDirectionEnum fromDisplayName(String name) {
		FxRegionUpperBoundDirectionEnum value = values.get(name);
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
