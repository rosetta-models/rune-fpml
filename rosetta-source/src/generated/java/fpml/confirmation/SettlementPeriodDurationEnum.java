package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.SettlementPeriodDurationEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the Settlement Period Duration for an Electricity Transaction.
 * @version ${project.version}
 */
@RosettaEnum("SettlementPeriodDurationEnum")
public enum SettlementPeriodDurationEnum {

	/**
	 * Two-hourly duration applies.
	 */
	@RosettaEnumValue(value = "_2_HOURS") 
	_2_HOURS("_2_HOURS", null),
	
	/**
	 * Hourly duration applies.
	 */
	@RosettaEnumValue(value = "_1_HOUR") 
	_1_HOUR("_1_HOUR", null),
	
	/**
	 * Half-hourly duration applies.
	 */
	@RosettaEnumValue(value = "_30_MINUTES") 
	_30_MINUTES("_30_MINUTES", null),
	
	/**
	 * Quarter-hourly duration applies.
	 */
	@RosettaEnumValue(value = "_15_MINUTES") 
	_15_MINUTES("_15_MINUTES", null)
;
	private static Map<String, SettlementPeriodDurationEnum> values;
	static {
        Map<String, SettlementPeriodDurationEnum> map = new ConcurrentHashMap<>();
		for (SettlementPeriodDurationEnum instance : SettlementPeriodDurationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SettlementPeriodDurationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SettlementPeriodDurationEnum fromDisplayName(String name) {
		SettlementPeriodDurationEnum value = values.get(name);
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
