package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DividendEntitlementEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DividendEntitlementEnum")
public enum DividendEntitlementEnum {

	@RosettaEnumValue(value = "EX_DATE") 
	EX_DATE("EX_DATE", null),
	
	@RosettaEnumValue(value = "RECORD_DATE") 
	RECORD_DATE("RECORD_DATE", null)
;
	private static Map<String, DividendEntitlementEnum> values;
	static {
        Map<String, DividendEntitlementEnum> map = new ConcurrentHashMap<>();
		for (DividendEntitlementEnum instance : DividendEntitlementEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendEntitlementEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendEntitlementEnum fromDisplayName(String name) {
		DividendEntitlementEnum value = values.get(name);
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
