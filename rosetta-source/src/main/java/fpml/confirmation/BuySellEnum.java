package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.BuySellEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("BuySellEnum")
public enum BuySellEnum {

	@RosettaEnumValue(value = "BUYER") 
	BUYER("BUYER", null),
	
	@RosettaEnumValue(value = "SELLER") 
	SELLER("SELLER", null)
;
	private static Map<String, BuySellEnum> values;
	static {
        Map<String, BuySellEnum> map = new ConcurrentHashMap<>();
		for (BuySellEnum instance : BuySellEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BuySellEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BuySellEnum fromDisplayName(String name) {
		BuySellEnum value = values.get(name);
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
