package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.NotionalAdjustmentEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("NotionalAdjustmentEnum")
public enum NotionalAdjustmentEnum {

	@RosettaEnumValue(value = "EXECUTION") 
	EXECUTION("EXECUTION", null),
	
	@RosettaEnumValue(value = "PORTFOLIO_REBALANCING") 
	PORTFOLIO_REBALANCING("PORTFOLIO_REBALANCING", null),
	
	@RosettaEnumValue(value = "STANDARD") 
	STANDARD("STANDARD", null)
;
	private static Map<String, NotionalAdjustmentEnum> values;
	static {
        Map<String, NotionalAdjustmentEnum> map = new ConcurrentHashMap<>();
		for (NotionalAdjustmentEnum instance : NotionalAdjustmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotionalAdjustmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotionalAdjustmentEnum fromDisplayName(String name) {
		NotionalAdjustmentEnum value = values.get(name);
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
