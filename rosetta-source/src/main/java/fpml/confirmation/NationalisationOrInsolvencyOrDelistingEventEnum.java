package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.NationalisationOrInsolvencyOrDelistingEventEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("NationalisationOrInsolvencyOrDelistingEventEnum")
public enum NationalisationOrInsolvencyOrDelistingEventEnum {

	@RosettaEnumValue(value = "NEGOTIATED_CLOSEOUT") 
	NEGOTIATED_CLOSEOUT("NEGOTIATED_CLOSEOUT", null),
	
	@RosettaEnumValue(value = "CANCELLATION_AND_PAYMENT") 
	CANCELLATION_AND_PAYMENT("CANCELLATION_AND_PAYMENT", null)
;
	private static Map<String, NationalisationOrInsolvencyOrDelistingEventEnum> values;
	static {
        Map<String, NationalisationOrInsolvencyOrDelistingEventEnum> map = new ConcurrentHashMap<>();
		for (NationalisationOrInsolvencyOrDelistingEventEnum instance : NationalisationOrInsolvencyOrDelistingEventEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NationalisationOrInsolvencyOrDelistingEventEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NationalisationOrInsolvencyOrDelistingEventEnum fromDisplayName(String name) {
		NationalisationOrInsolvencyOrDelistingEventEnum value = values.get(name);
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
