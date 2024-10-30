package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.MarketDisruptionEventsEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of how market disruption events will be represented.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("MarketDisruptionEventsEnum")
public enum MarketDisruptionEventsEnum {

	/**
	 * Market Disruption Events are applicable.
	 */
	@RosettaEnumValue(value = "APPLICABLE") 
	APPLICABLE("APPLICABLE", null),
	
	/**
	 * Market Disruption Events are not applicable.
	 */
	@RosettaEnumValue(value = "NOT_APPLICABLE") 
	NOT_APPLICABLE("NOT_APPLICABLE", null),
	
	/**
	 * The Market Disruption Event(s) are determined by reference to the relevant Master Agreement.
	 */
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_MASTER_AGREEMENT") 
	AS_SPECIFIED_IN_MASTER_AGREEMENT("AS_SPECIFIED_IN_MASTER_AGREEMENT", null),
	
	/**
	 * The Market Disruption Event(s) are determined by reference to the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "AS_SPECIFIED_IN_CONFIRMATION") 
	AS_SPECIFIED_IN_CONFIRMATION("AS_SPECIFIED_IN_CONFIRMATION", null)
;
	private static Map<String, MarketDisruptionEventsEnum> values;
	static {
        Map<String, MarketDisruptionEventsEnum> map = new ConcurrentHashMap<>();
		for (MarketDisruptionEventsEnum instance : MarketDisruptionEventsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MarketDisruptionEventsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MarketDisruptionEventsEnum fromDisplayName(String name) {
		MarketDisruptionEventsEnum value = values.get(name);
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
