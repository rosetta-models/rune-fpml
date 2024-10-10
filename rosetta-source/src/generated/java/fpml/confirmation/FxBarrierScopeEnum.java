package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxBarrierScopeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FxBarrierScopeEnum")
public enum FxBarrierScopeEnum {

	@RosettaEnumValue(value = "GLOBAL") 
	GLOBAL("GLOBAL", null),
	
	@RosettaEnumValue(value = "PER_EXPIRY") 
	PER_EXPIRY("PER_EXPIRY", null)
;
	private static Map<String, FxBarrierScopeEnum> values;
	static {
        Map<String, FxBarrierScopeEnum> map = new ConcurrentHashMap<>();
		for (FxBarrierScopeEnum instance : FxBarrierScopeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxBarrierScopeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxBarrierScopeEnum fromDisplayName(String name) {
		FxBarrierScopeEnum value = values.get(name);
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
