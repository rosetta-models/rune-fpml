package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxRegionLowerBoundDirectionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The Lower Bound Direction. It only contains the AtOrAbove and Above values.
 * @version ${project.version}
 */
@RosettaEnum("FxRegionLowerBoundDirectionEnum")
public enum FxRegionLowerBoundDirectionEnum {

	@RosettaEnumValue(value = "AT_OR_ABOVE") 
	AT_OR_ABOVE("AT_OR_ABOVE", null),
	
	@RosettaEnumValue(value = "ABOVE") 
	ABOVE("ABOVE", null)
;
	private static Map<String, FxRegionLowerBoundDirectionEnum> values;
	static {
        Map<String, FxRegionLowerBoundDirectionEnum> map = new ConcurrentHashMap<>();
		for (FxRegionLowerBoundDirectionEnum instance : FxRegionLowerBoundDirectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxRegionLowerBoundDirectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxRegionLowerBoundDirectionEnum fromDisplayName(String name) {
		FxRegionLowerBoundDirectionEnum value = values.get(name);
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
