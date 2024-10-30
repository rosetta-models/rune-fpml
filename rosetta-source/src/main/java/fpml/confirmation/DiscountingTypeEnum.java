package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DiscountingTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The method of calculating discounted payment amounts.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("DiscountingTypeEnum")
public enum DiscountingTypeEnum {

	@RosettaEnumValue(value = "STANDARD") 
	STANDARD("STANDARD", null),
	
	@RosettaEnumValue(value = "FRA") 
	FRA("FRA", null),
	
	@RosettaEnumValue(value = "FRAYIELD") 
	FRAYIELD("FRAYIELD", null)
;
	private static Map<String, DiscountingTypeEnum> values;
	static {
        Map<String, DiscountingTypeEnum> map = new ConcurrentHashMap<>();
		for (DiscountingTypeEnum instance : DiscountingTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DiscountingTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DiscountingTypeEnum fromDisplayName(String name) {
		DiscountingTypeEnum value = values.get(name);
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
