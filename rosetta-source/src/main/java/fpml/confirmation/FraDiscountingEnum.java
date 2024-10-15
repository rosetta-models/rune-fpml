package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FraDiscountingEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FraDiscountingEnum")
public enum FraDiscountingEnum {

	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	@RosettaEnumValue(value = "AFMA") 
	AFMA("AFMA", null),
	
	@RosettaEnumValue(value = "NONE") 
	NONE("NONE", null),
	
	@RosettaEnumValue(value = "ISDAYIELD") 
	ISDAYIELD("ISDAYIELD", null)
;
	private static Map<String, FraDiscountingEnum> values;
	static {
        Map<String, FraDiscountingEnum> map = new ConcurrentHashMap<>();
		for (FraDiscountingEnum instance : FraDiscountingEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FraDiscountingEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FraDiscountingEnum fromDisplayName(String name) {
		FraDiscountingEnum value = values.get(name);
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
