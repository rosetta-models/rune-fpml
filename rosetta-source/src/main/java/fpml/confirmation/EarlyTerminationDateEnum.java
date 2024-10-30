package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.EarlyTerminationDateEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Symbolic specification of early termination date.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("EarlyTerminationDateEnum")
public enum EarlyTerminationDateEnum {

	@RosettaEnumValue(value = "ANY_DAY") 
	ANY_DAY("ANY_DAY", null),
	
	@RosettaEnumValue(value = "VALUATION_DATE") 
	VALUATION_DATE("VALUATION_DATE", null),
	
	@RosettaEnumValue(value = "RESET_DATE") 
	RESET_DATE("RESET_DATE", null),
	
	@RosettaEnumValue(value = "AFTER_FIRST_RESET_DATE") 
	AFTER_FIRST_RESET_DATE("AFTER_FIRST_RESET_DATE", null),
	
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_MCA") 
	AS_SPECIFIED_IN_MCA("AS_SPECIFIED_IN_MCA", null)
;
	private static Map<String, EarlyTerminationDateEnum> values;
	static {
        Map<String, EarlyTerminationDateEnum> map = new ConcurrentHashMap<>();
		for (EarlyTerminationDateEnum instance : EarlyTerminationDateEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EarlyTerminationDateEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EarlyTerminationDateEnum fromDisplayName(String name) {
		EarlyTerminationDateEnum value = values.get(name);
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
