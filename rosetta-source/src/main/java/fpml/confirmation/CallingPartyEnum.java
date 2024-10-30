package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CallingPartyEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("CallingPartyEnum")
public enum CallingPartyEnum {

	@RosettaEnumValue(value = "INITIAL_BUYER") 
	INITIAL_BUYER("INITIAL_BUYER", null),
	
	@RosettaEnumValue(value = "INITIAL_SELLER") 
	INITIAL_SELLER("INITIAL_SELLER", null),
	
	@RosettaEnumValue(value = "EITHER") 
	EITHER("EITHER", null),
	
	@RosettaEnumValue(value = "AS_DEFINED_IN_MASTER_AGREEMENT") 
	AS_DEFINED_IN_MASTER_AGREEMENT("AS_DEFINED_IN_MASTER_AGREEMENT", null)
;
	private static Map<String, CallingPartyEnum> values;
	static {
        Map<String, CallingPartyEnum> map = new ConcurrentHashMap<>();
		for (CallingPartyEnum instance : CallingPartyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CallingPartyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CallingPartyEnum fromDisplayName(String name) {
		CallingPartyEnum value = values.get(name);
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
