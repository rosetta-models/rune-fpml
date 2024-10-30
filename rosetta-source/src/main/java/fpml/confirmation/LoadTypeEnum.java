package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoadTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("LoadTypeEnum")
public enum LoadTypeEnum {

	/**
	 * Base
	 */
	@RosettaEnumValue(value = "BASE") 
	BASE("BASE", null),
	
	/**
	 * Peak
	 */
	@RosettaEnumValue(value = "PEAK") 
	PEAK("PEAK", null),
	
	/**
	 * Off-Peak
	 */
	@RosettaEnumValue(value = "OFF_PEAK") 
	OFF_PEAK("OFF_PEAK", null),
	
	/**
	 * Block Hours
	 */
	@RosettaEnumValue(value = "BLOCK_HOURS") 
	BLOCK_HOURS("BLOCK_HOURS", null),
	
	/**
	 * Anything that does not fall under the predefined standard categories
	 */
	@RosettaEnumValue(value = "CUSTOM") 
	CUSTOM("CUSTOM", null)
;
	private static Map<String, LoadTypeEnum> values;
	static {
        Map<String, LoadTypeEnum> map = new ConcurrentHashMap<>();
		for (LoadTypeEnum instance : LoadTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoadTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoadTypeEnum fromDisplayName(String name) {
		LoadTypeEnum value = values.get(name);
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
