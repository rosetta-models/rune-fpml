package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ConditionsPrecedentMetEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ConditionsPrecedentMetEnum")
public enum ConditionsPrecedentMetEnum {

	@RosettaEnumValue(value = "NO") 
	NO("NO", null),
	
	@RosettaEnumValue(value = "WAIVED") 
	WAIVED("WAIVED", null),
	
	@RosettaEnumValue(value = "YES") 
	YES("YES", null)
;
	private static Map<String, ConditionsPrecedentMetEnum> values;
	static {
        Map<String, ConditionsPrecedentMetEnum> map = new ConcurrentHashMap<>();
		for (ConditionsPrecedentMetEnum instance : ConditionsPrecedentMetEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ConditionsPrecedentMetEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ConditionsPrecedentMetEnum fromDisplayName(String name) {
		ConditionsPrecedentMetEnum value = values.get(name);
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
