package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.NonCashDividendTreatmentEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("NonCashDividendTreatmentEnum")
public enum NonCashDividendTreatmentEnum {

	@RosettaEnumValue(value = "POTENTIAL_ADJUSTMENT_EVENT") 
	POTENTIAL_ADJUSTMENT_EVENT("POTENTIAL_ADJUSTMENT_EVENT", null),
	
	@RosettaEnumValue(value = "CASH_EQUIVALENT") 
	CASH_EQUIVALENT("CASH_EQUIVALENT", null)
;
	private static Map<String, NonCashDividendTreatmentEnum> values;
	static {
        Map<String, NonCashDividendTreatmentEnum> map = new ConcurrentHashMap<>();
		for (NonCashDividendTreatmentEnum instance : NonCashDividendTreatmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NonCashDividendTreatmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NonCashDividendTreatmentEnum fromDisplayName(String name) {
		NonCashDividendTreatmentEnum value = values.get(name);
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
