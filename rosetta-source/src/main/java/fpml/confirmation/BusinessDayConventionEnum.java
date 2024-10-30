package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.BusinessDayConventionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("BusinessDayConventionEnum")
public enum BusinessDayConventionEnum {

	@RosettaEnumValue(value = "FOLLOWING") 
	FOLLOWING("FOLLOWING", null),
	
	@RosettaEnumValue(value = "FRN") 
	FRN("FRN", null),
	
	@RosettaEnumValue(value = "MODFOLLOWING") 
	MODFOLLOWING("MODFOLLOWING", null),
	
	@RosettaEnumValue(value = "PRECEDING") 
	PRECEDING("PRECEDING", null),
	
	@RosettaEnumValue(value = "MODPRECEDING") 
	MODPRECEDING("MODPRECEDING", null),
	
	@RosettaEnumValue(value = "NEAREST") 
	NEAREST("NEAREST", null),
	
	@RosettaEnumValue(value = "NONE") 
	NONE("NONE", null),
	
	@RosettaEnumValue(value = "NOT_APPLICABLE") 
	NOT_APPLICABLE("NOT_APPLICABLE", null)
;
	private static Map<String, BusinessDayConventionEnum> values;
	static {
        Map<String, BusinessDayConventionEnum> map = new ConcurrentHashMap<>();
		for (BusinessDayConventionEnum instance : BusinessDayConventionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BusinessDayConventionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BusinessDayConventionEnum fromDisplayName(String name) {
		BusinessDayConventionEnum value = values.get(name);
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
