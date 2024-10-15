package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.StrikeQuoteBasisEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("StrikeQuoteBasisEnum")
public enum StrikeQuoteBasisEnum {

	@RosettaEnumValue(value = "PUT_CURRENCY_PER_CALL_CURRENCY") 
	PUT_CURRENCY_PER_CALL_CURRENCY("PUT_CURRENCY_PER_CALL_CURRENCY", null),
	
	@RosettaEnumValue(value = "CALL_CURRENCY_PER_PUT_CURRENCY") 
	CALL_CURRENCY_PER_PUT_CURRENCY("CALL_CURRENCY_PER_PUT_CURRENCY", null)
;
	private static Map<String, StrikeQuoteBasisEnum> values;
	static {
        Map<String, StrikeQuoteBasisEnum> map = new ConcurrentHashMap<>();
		for (StrikeQuoteBasisEnum instance : StrikeQuoteBasisEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	StrikeQuoteBasisEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static StrikeQuoteBasisEnum fromDisplayName(String name) {
		StrikeQuoteBasisEnum value = values.get(name);
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
