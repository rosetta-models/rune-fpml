package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PremiumQuoteBasisEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("PremiumQuoteBasisEnum")
public enum PremiumQuoteBasisEnum {

	@RosettaEnumValue(value = "PERCENTAGE_OF_CALL_CURRENCY_AMOUNT") 
	PERCENTAGE_OF_CALL_CURRENCY_AMOUNT("PERCENTAGE_OF_CALL_CURRENCY_AMOUNT", null),
	
	@RosettaEnumValue(value = "PERCENTAGE_OF_PUT_CURRENCY_AMOUNT") 
	PERCENTAGE_OF_PUT_CURRENCY_AMOUNT("PERCENTAGE_OF_PUT_CURRENCY_AMOUNT", null),
	
	@RosettaEnumValue(value = "CALL_CURRENCY_PER_PUT_CURRENCY") 
	CALL_CURRENCY_PER_PUT_CURRENCY("CALL_CURRENCY_PER_PUT_CURRENCY", null),
	
	@RosettaEnumValue(value = "PUT_CURRENCY_PER_CALL_CURRENCY") 
	PUT_CURRENCY_PER_CALL_CURRENCY("PUT_CURRENCY_PER_CALL_CURRENCY", null),
	
	@RosettaEnumValue(value = "EXPLICIT") 
	EXPLICIT("EXPLICIT", null)
;
	private static Map<String, PremiumQuoteBasisEnum> values;
	static {
        Map<String, PremiumQuoteBasisEnum> map = new ConcurrentHashMap<>();
		for (PremiumQuoteBasisEnum instance : PremiumQuoteBasisEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PremiumQuoteBasisEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PremiumQuoteBasisEnum fromDisplayName(String name) {
		PremiumQuoteBasisEnum value = values.get(name);
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
