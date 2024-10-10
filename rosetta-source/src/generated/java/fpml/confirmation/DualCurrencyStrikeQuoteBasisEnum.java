package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DualCurrencyStrikeQuoteBasisEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A type which permits the Dual Currency strike quote basis to be expressed in terms of the deposit and alternate currencies.
 * @version ${project.version}
 */
@RosettaEnum("DualCurrencyStrikeQuoteBasisEnum")
public enum DualCurrencyStrikeQuoteBasisEnum {

	@RosettaEnumValue(value = "DEPOSIT_CURRENCY_PER_ALTERNATE_CURRENCY") 
	DEPOSIT_CURRENCY_PER_ALTERNATE_CURRENCY("DEPOSIT_CURRENCY_PER_ALTERNATE_CURRENCY", null),
	
	@RosettaEnumValue(value = "ALTERNATE_CURRENCY_PER_DEPOSIT_CURRENCY") 
	ALTERNATE_CURRENCY_PER_DEPOSIT_CURRENCY("ALTERNATE_CURRENCY_PER_DEPOSIT_CURRENCY", null)
;
	private static Map<String, DualCurrencyStrikeQuoteBasisEnum> values;
	static {
        Map<String, DualCurrencyStrikeQuoteBasisEnum> map = new ConcurrentHashMap<>();
		for (DualCurrencyStrikeQuoteBasisEnum instance : DualCurrencyStrikeQuoteBasisEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DualCurrencyStrikeQuoteBasisEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DualCurrencyStrikeQuoteBasisEnum fromDisplayName(String name) {
		DualCurrencyStrikeQuoteBasisEnum value = values.get(name);
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
