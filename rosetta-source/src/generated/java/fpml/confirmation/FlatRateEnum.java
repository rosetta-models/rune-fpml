package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FlatRateEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The method by which the Flat Rate is calculated for a commodity freight transaction.
 * @version ${project.version}
 */
@RosettaEnum("FlatRateEnum")
public enum FlatRateEnum {

	@RosettaEnumValue(value = "FIXED") 
	FIXED("FIXED", null),
	
	@RosettaEnumValue(value = "FLOATING") 
	FLOATING("FLOATING", null)
;
	private static Map<String, FlatRateEnum> values;
	static {
        Map<String, FlatRateEnum> map = new ConcurrentHashMap<>();
		for (FlatRateEnum instance : FlatRateEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FlatRateEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FlatRateEnum fromDisplayName(String name) {
		FlatRateEnum value = values.get(name);
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
