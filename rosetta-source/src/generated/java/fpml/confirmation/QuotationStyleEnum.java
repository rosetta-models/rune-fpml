package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.QuotationStyleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("QuotationStyleEnum")
public enum QuotationStyleEnum {

	@RosettaEnumValue(value = "POINTS_UP_FRONT") 
	POINTS_UP_FRONT("POINTS_UP_FRONT", null),
	
	@RosettaEnumValue(value = "TRADED_SPREAD") 
	TRADED_SPREAD("TRADED_SPREAD", null),
	
	@RosettaEnumValue(value = "PRICE") 
	PRICE("PRICE", null)
;
	private static Map<String, QuotationStyleEnum> values;
	static {
        Map<String, QuotationStyleEnum> map = new ConcurrentHashMap<>();
		for (QuotationStyleEnum instance : QuotationStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	QuotationStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static QuotationStyleEnum fromDisplayName(String name) {
		QuotationStyleEnum value = values.get(name);
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
