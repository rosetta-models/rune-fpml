package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.QuotationSideEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("QuotationSideEnum")
public enum QuotationSideEnum {

	@RosettaEnumValue(value = "BID") 
	BID("BID", null),
	
	@RosettaEnumValue(value = "ASK") 
	ASK("ASK", null),
	
	@RosettaEnumValue(value = "MID") 
	MID("MID", null)
;
	private static Map<String, QuotationSideEnum> values;
	static {
        Map<String, QuotationSideEnum> map = new ConcurrentHashMap<>();
		for (QuotationSideEnum instance : QuotationSideEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	QuotationSideEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static QuotationSideEnum fromDisplayName(String name) {
		QuotationSideEnum value = values.get(name);
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
