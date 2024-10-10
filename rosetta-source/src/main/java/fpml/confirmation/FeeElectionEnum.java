package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FeeElectionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the fee type.
 * @version ${project.version}
 */
@RosettaEnum("FeeElectionEnum")
public enum FeeElectionEnum {

	@RosettaEnumValue(value = "FLAT_FEE") 
	FLAT_FEE("FLAT_FEE", null),
	
	@RosettaEnumValue(value = "AMORTIZED_FEE") 
	AMORTIZED_FEE("AMORTIZED_FEE", null),
	
	@RosettaEnumValue(value = "FUNDING_FEE") 
	FUNDING_FEE("FUNDING_FEE", null),
	
	@RosettaEnumValue(value = "FLAT_FEE_AND_FUNDING_FEE") 
	FLAT_FEE_AND_FUNDING_FEE("FLAT_FEE_AND_FUNDING_FEE", null),
	
	@RosettaEnumValue(value = "AMORTIZED_FEE_AND_FUNDING_FEE") 
	AMORTIZED_FEE_AND_FUNDING_FEE("AMORTIZED_FEE_AND_FUNDING_FEE", null)
;
	private static Map<String, FeeElectionEnum> values;
	static {
        Map<String, FeeElectionEnum> map = new ConcurrentHashMap<>();
		for (FeeElectionEnum instance : FeeElectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FeeElectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FeeElectionEnum fromDisplayName(String name) {
		FeeElectionEnum value = values.get(name);
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
