package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.AccrualReferenceAmountTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("AccrualReferenceAmountTypeEnum")
public enum AccrualReferenceAmountTypeEnum {

	@RosettaEnumValue(value = "COMMITMENT") 
	COMMITMENT("COMMITMENT", null),
	
	@RosettaEnumValue(value = "FUNDED") 
	FUNDED("FUNDED", null),
	
	@RosettaEnumValue(value = "OTHER") 
	OTHER("OTHER", null),
	
	@RosettaEnumValue(value = "UNFUNDED") 
	UNFUNDED("UNFUNDED", null),
	
	@RosettaEnumValue(value = "UNUTILIZED") 
	UNUTILIZED("UNUTILIZED", null),
	
	@RosettaEnumValue(value = "UTILIZED") 
	UTILIZED("UTILIZED", null)
;
	private static Map<String, AccrualReferenceAmountTypeEnum> values;
	static {
        Map<String, AccrualReferenceAmountTypeEnum> map = new ConcurrentHashMap<>();
		for (AccrualReferenceAmountTypeEnum instance : AccrualReferenceAmountTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AccrualReferenceAmountTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AccrualReferenceAmountTypeEnum fromDisplayName(String name) {
		AccrualReferenceAmountTypeEnum value = values.get(name);
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
