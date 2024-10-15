package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxOffsetConventionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Standard FX Spot and Forward offset conventions.
 * @version ${project.version}
 */
@RosettaEnum("FxOffsetConventionEnum")
public enum FxOffsetConventionEnum {

	@RosettaEnumValue(value = "FX_SPOT") 
	FX_SPOT("FX_SPOT", null),
	
	@RosettaEnumValue(value = "FX_FORWARD") 
	FX_FORWARD("FX_FORWARD", null)
;
	private static Map<String, FxOffsetConventionEnum> values;
	static {
        Map<String, FxOffsetConventionEnum> map = new ConcurrentHashMap<>();
		for (FxOffsetConventionEnum instance : FxOffsetConventionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxOffsetConventionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxOffsetConventionEnum fromDisplayName(String name) {
		FxOffsetConventionEnum value = values.get(name);
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
