package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.SettlementTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("SettlementTypeEnum")
public enum SettlementTypeEnum {

	@RosettaEnumValue(value = "CASH") 
	CASH("CASH", null),
	
	@RosettaEnumValue(value = "PHYSICAL") 
	PHYSICAL("PHYSICAL", null),
	
	@RosettaEnumValue(value = "ELECTION") 
	ELECTION("ELECTION", null),
	
	@RosettaEnumValue(value = "CASH_OR_PHYSICAL") 
	CASH_OR_PHYSICAL("CASH_OR_PHYSICAL", null)
;
	private static Map<String, SettlementTypeEnum> values;
	static {
        Map<String, SettlementTypeEnum> map = new ConcurrentHashMap<>();
		for (SettlementTypeEnum instance : SettlementTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SettlementTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SettlementTypeEnum fromDisplayName(String name) {
		SettlementTypeEnum value = values.get(name);
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
