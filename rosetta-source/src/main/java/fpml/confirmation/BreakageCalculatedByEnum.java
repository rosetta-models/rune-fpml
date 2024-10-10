package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.BreakageCalculatedByEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * When breakage cost is applicable, this defines who is calculating it.
 * @version ${project.version}
 */
@RosettaEnum("BreakageCalculatedByEnum")
public enum BreakageCalculatedByEnum {

	/**
	 * Breakage cost is calculated by the agent bank.
	 */
	@RosettaEnumValue(value = "AGENT_BANK") 
	AGENT_BANK("AGENT_BANK", null),
	
	/**
	 * Breakage cost is calculated by the lender.
	 */
	@RosettaEnumValue(value = "LENDER") 
	LENDER("LENDER", null)
;
	private static Map<String, BreakageCalculatedByEnum> values;
	static {
        Map<String, BreakageCalculatedByEnum> map = new ConcurrentHashMap<>();
		for (BreakageCalculatedByEnum instance : BreakageCalculatedByEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BreakageCalculatedByEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BreakageCalculatedByEnum fromDisplayName(String name) {
		BreakageCalculatedByEnum value = values.get(name);
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
