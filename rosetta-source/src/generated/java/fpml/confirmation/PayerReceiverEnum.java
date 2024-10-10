package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PayerReceiverEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("PayerReceiverEnum")
public enum PayerReceiverEnum {

	@RosettaEnumValue(value = "PAYER") 
	PAYER("PAYER", null),
	
	@RosettaEnumValue(value = "RECEIVER") 
	RECEIVER("RECEIVER", null)
;
	private static Map<String, PayerReceiverEnum> values;
	static {
        Map<String, PayerReceiverEnum> map = new ConcurrentHashMap<>();
		for (PayerReceiverEnum instance : PayerReceiverEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PayerReceiverEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PayerReceiverEnum fromDisplayName(String name) {
		PayerReceiverEnum value = values.get(name);
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
