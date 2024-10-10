package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxBarrierTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FxBarrierTypeEnum")
public enum FxBarrierTypeEnum {

	@RosettaEnumValue(value = "KNOCKIN") 
	KNOCKIN("KNOCKIN", null),
	
	@RosettaEnumValue(value = "KNOCKOUT") 
	KNOCKOUT("KNOCKOUT", null),
	
	@RosettaEnumValue(value = "REVERSE_KNOCKIN") 
	REVERSE_KNOCKIN("REVERSE_KNOCKIN", null),
	
	@RosettaEnumValue(value = "REVERSE_KNOCKOUT") 
	REVERSE_KNOCKOUT("REVERSE_KNOCKOUT", null)
;
	private static Map<String, FxBarrierTypeEnum> values;
	static {
        Map<String, FxBarrierTypeEnum> map = new ConcurrentHashMap<>();
		for (FxBarrierTypeEnum instance : FxBarrierTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxBarrierTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxBarrierTypeEnum fromDisplayName(String name) {
		FxBarrierTypeEnum value = values.get(name);
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
