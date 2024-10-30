package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DividendCompositionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("DividendCompositionEnum")
public enum DividendCompositionEnum {

	@RosettaEnumValue(value = "EQUITY_AMOUNT_RECEIVER_ELECTION") 
	EQUITY_AMOUNT_RECEIVER_ELECTION("EQUITY_AMOUNT_RECEIVER_ELECTION", null),
	
	@RosettaEnumValue(value = "CALCULATION_AGENT_ELECTION") 
	CALCULATION_AGENT_ELECTION("CALCULATION_AGENT_ELECTION", null)
;
	private static Map<String, DividendCompositionEnum> values;
	static {
        Map<String, DividendCompositionEnum> map = new ConcurrentHashMap<>();
		for (DividendCompositionEnum instance : DividendCompositionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendCompositionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendCompositionEnum fromDisplayName(String name) {
		DividendCompositionEnum value = values.get(name);
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
