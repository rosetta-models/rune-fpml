package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.TelephoneTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("TelephoneTypeEnum")
public enum TelephoneTypeEnum {

	@RosettaEnumValue(value = "WORK") 
	WORK("WORK", null),
	
	@RosettaEnumValue(value = "MOBILE") 
	MOBILE("MOBILE", null),
	
	@RosettaEnumValue(value = "FAX") 
	FAX("FAX", null),
	
	@RosettaEnumValue(value = "PERSONAL") 
	PERSONAL("PERSONAL", null)
;
	private static Map<String, TelephoneTypeEnum> values;
	static {
        Map<String, TelephoneTypeEnum> map = new ConcurrentHashMap<>();
		for (TelephoneTypeEnum instance : TelephoneTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TelephoneTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TelephoneTypeEnum fromDisplayName(String name) {
		TelephoneTypeEnum value = values.get(name);
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
