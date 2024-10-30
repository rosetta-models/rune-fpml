package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CommodityKnockEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("CommodityKnockEnum")
public enum CommodityKnockEnum {

	@RosettaEnumValue(value = "IN") 
	IN("IN", null),
	
	@RosettaEnumValue(value = "OUT") 
	OUT("OUT", null)
;
	private static Map<String, CommodityKnockEnum> values;
	static {
        Map<String, CommodityKnockEnum> map = new ConcurrentHashMap<>();
		for (CommodityKnockEnum instance : CommodityKnockEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityKnockEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityKnockEnum fromDisplayName(String name) {
		CommodityKnockEnum value = values.get(name);
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
