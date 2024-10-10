package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DeliveryNearbyTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DeliveryNearbyTypeEnum")
public enum DeliveryNearbyTypeEnum {

	@RosettaEnumValue(value = "CALCULATION_PERIOD") 
	CALCULATION_PERIOD("CALCULATION_PERIOD", null),
	
	@RosettaEnumValue(value = "NEARBY_MONTH") 
	NEARBY_MONTH("NEARBY_MONTH", null),
	
	@RosettaEnumValue(value = "NEARBY_WEEK") 
	NEARBY_WEEK("NEARBY_WEEK", null)
;
	private static Map<String, DeliveryNearbyTypeEnum> values;
	static {
        Map<String, DeliveryNearbyTypeEnum> map = new ConcurrentHashMap<>();
		for (DeliveryNearbyTypeEnum instance : DeliveryNearbyTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DeliveryNearbyTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DeliveryNearbyTypeEnum fromDisplayName(String name) {
		DeliveryNearbyTypeEnum value = values.get(name);
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
