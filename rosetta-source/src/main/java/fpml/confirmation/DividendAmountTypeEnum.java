package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DividendAmountTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DividendAmountTypeEnum")
public enum DividendAmountTypeEnum {

	@RosettaEnumValue(value = "RECORD_AMOUNT") 
	RECORD_AMOUNT("RECORD_AMOUNT", null),
	
	@RosettaEnumValue(value = "EX_AMOUNT") 
	EX_AMOUNT("EX_AMOUNT", null),
	
	@RosettaEnumValue(value = "PAID_AMOUNT") 
	PAID_AMOUNT("PAID_AMOUNT", null),
	
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_MASTER_CONFIRMATION") 
	AS_SPECIFIED_IN_MASTER_CONFIRMATION("AS_SPECIFIED_IN_MASTER_CONFIRMATION", null)
;
	private static Map<String, DividendAmountTypeEnum> values;
	static {
        Map<String, DividendAmountTypeEnum> map = new ConcurrentHashMap<>();
		for (DividendAmountTypeEnum instance : DividendAmountTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendAmountTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendAmountTypeEnum fromDisplayName(String name) {
		DividendAmountTypeEnum value = values.get(name);
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
