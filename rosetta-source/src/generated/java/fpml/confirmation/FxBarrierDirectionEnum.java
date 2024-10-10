package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxBarrierDirectionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FxBarrierDirectionEnum")
public enum FxBarrierDirectionEnum {

	@RosettaEnumValue(value = "DOWN") 
	DOWN("DOWN", null),
	
	@RosettaEnumValue(value = "UP") 
	UP("UP", null)
;
	private static Map<String, FxBarrierDirectionEnum> values;
	static {
        Map<String, FxBarrierDirectionEnum> map = new ConcurrentHashMap<>();
		for (FxBarrierDirectionEnum instance : FxBarrierDirectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxBarrierDirectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxBarrierDirectionEnum fromDisplayName(String name) {
		FxBarrierDirectionEnum value = values.get(name);
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
