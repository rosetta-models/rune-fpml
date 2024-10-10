package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DeliveryTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DeliveryTypeEnum")
public enum DeliveryTypeEnum {

	@RosettaEnumValue(value = "FIRM") 
	FIRM("FIRM", null),
	
	@RosettaEnumValue(value = "INTERRUPTIBLE") 
	INTERRUPTIBLE("INTERRUPTIBLE", null)
;
	private static Map<String, DeliveryTypeEnum> values;
	static {
        Map<String, DeliveryTypeEnum> map = new ConcurrentHashMap<>();
		for (DeliveryTypeEnum instance : DeliveryTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DeliveryTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DeliveryTypeEnum fromDisplayName(String name) {
		DeliveryTypeEnum value = values.get(name);
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
