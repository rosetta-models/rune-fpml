package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxBarrierTypeSimpleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("FxBarrierTypeSimpleEnum")
public enum FxBarrierTypeSimpleEnum {

	@RosettaEnumValue(value = "KNOCKIN") 
	KNOCKIN("KNOCKIN", null),
	
	@RosettaEnumValue(value = "KNOCKOUT") 
	KNOCKOUT("KNOCKOUT", null)
;
	private static Map<String, FxBarrierTypeSimpleEnum> values;
	static {
        Map<String, FxBarrierTypeSimpleEnum> map = new ConcurrentHashMap<>();
		for (FxBarrierTypeSimpleEnum instance : FxBarrierTypeSimpleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxBarrierTypeSimpleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxBarrierTypeSimpleEnum fromDisplayName(String name) {
		FxBarrierTypeSimpleEnum value = values.get(name);
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
