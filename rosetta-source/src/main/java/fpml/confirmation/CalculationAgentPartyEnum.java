package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CalculationAgentPartyEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CalculationAgentPartyEnum")
public enum CalculationAgentPartyEnum {

	@RosettaEnumValue(value = "EXERCISING_PARTY") 
	EXERCISING_PARTY("EXERCISING_PARTY", null),
	
	@RosettaEnumValue(value = "NON_EXERCISING_PARTY") 
	NON_EXERCISING_PARTY("NON_EXERCISING_PARTY", null),
	
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_MASTER_AGREEMENT") 
	AS_SPECIFIED_IN_MASTER_AGREEMENT("AS_SPECIFIED_IN_MASTER_AGREEMENT", null),
	
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT") 
	AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT("AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT", null),
	
	@RosettaEnumValue(value = "BOTH") 
	BOTH("BOTH", null)
;
	private static Map<String, CalculationAgentPartyEnum> values;
	static {
        Map<String, CalculationAgentPartyEnum> map = new ConcurrentHashMap<>();
		for (CalculationAgentPartyEnum instance : CalculationAgentPartyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CalculationAgentPartyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CalculationAgentPartyEnum fromDisplayName(String name) {
		CalculationAgentPartyEnum value = values.get(name);
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
