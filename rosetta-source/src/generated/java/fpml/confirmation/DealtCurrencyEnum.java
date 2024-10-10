package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DealtCurrencyEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DealtCurrencyEnum")
public enum DealtCurrencyEnum {

	@RosettaEnumValue(value = "EXCHANGED_CURRENCY1") 
	EXCHANGED_CURRENCY1("EXCHANGED_CURRENCY1", null),
	
	@RosettaEnumValue(value = "EXCHANGED_CURRENCY2") 
	EXCHANGED_CURRENCY2("EXCHANGED_CURRENCY2", null)
;
	private static Map<String, DealtCurrencyEnum> values;
	static {
        Map<String, DealtCurrencyEnum> map = new ConcurrentHashMap<>();
		for (DealtCurrencyEnum instance : DealtCurrencyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DealtCurrencyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DealtCurrencyEnum fromDisplayName(String name) {
		DealtCurrencyEnum value = values.get(name);
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
