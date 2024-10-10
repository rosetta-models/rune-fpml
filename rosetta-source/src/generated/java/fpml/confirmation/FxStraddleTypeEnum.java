package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxStraddleTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FxStraddleTypeEnum")
public enum FxStraddleTypeEnum {

	@RosettaEnumValue(value = "AT_THE_MONEY_FORWARD") 
	AT_THE_MONEY_FORWARD("AT_THE_MONEY_FORWARD", null),
	
	@RosettaEnumValue(value = "DELTA_NEUTRAL") 
	DELTA_NEUTRAL("DELTA_NEUTRAL", null)
;
	private static Map<String, FxStraddleTypeEnum> values;
	static {
        Map<String, FxStraddleTypeEnum> map = new ConcurrentHashMap<>();
		for (FxStraddleTypeEnum instance : FxStraddleTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxStraddleTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxStraddleTypeEnum fromDisplayName(String name) {
		FxStraddleTypeEnum value = values.get(name);
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
