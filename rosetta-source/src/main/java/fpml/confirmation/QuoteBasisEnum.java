package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.QuoteBasisEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("QuoteBasisEnum")
public enum QuoteBasisEnum {

	@RosettaEnumValue(value = "CURRENCY1_PER_CURRENCY2") 
	CURRENCY1_PER_CURRENCY2("CURRENCY1_PER_CURRENCY2", null),
	
	@RosettaEnumValue(value = "CURRENCY2_PER_CURRENCY1") 
	CURRENCY2_PER_CURRENCY1("CURRENCY2_PER_CURRENCY1", null)
;
	private static Map<String, QuoteBasisEnum> values;
	static {
        Map<String, QuoteBasisEnum> map = new ConcurrentHashMap<>();
		for (QuoteBasisEnum instance : QuoteBasisEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	QuoteBasisEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static QuoteBasisEnum fromDisplayName(String name) {
		QuoteBasisEnum value = values.get(name);
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
