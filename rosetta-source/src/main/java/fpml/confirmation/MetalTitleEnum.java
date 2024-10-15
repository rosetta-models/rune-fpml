package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.MetalTitleEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Describes how and when title to the commodity transfers.
 * @version ${project.version}
 */
@RosettaEnum("MetalTitleEnum")
public enum MetalTitleEnum {

	/**
	 * Transfers with Risk of Loss.
	 */
	@RosettaEnumValue(value = "TRANSFERS_WITH_RISK_OF_LOSS") 
	TRANSFERS_WITH_RISK_OF_LOSS("TRANSFERS_WITH_RISK_OF_LOSS", null),
	
	/**
	 * Does Not Transfer with Risk of Loss.
	 */
	@RosettaEnumValue(value = "DOES_NOT_TRANSFER_WITH_RISK_OF_LOSS") 
	DOES_NOT_TRANSFER_WITH_RISK_OF_LOSS("DOES_NOT_TRANSFER_WITH_RISK_OF_LOSS", null)
;
	private static Map<String, MetalTitleEnum> values;
	static {
        Map<String, MetalTitleEnum> map = new ConcurrentHashMap<>();
		for (MetalTitleEnum instance : MetalTitleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MetalTitleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MetalTitleEnum fromDisplayName(String name) {
		MetalTitleEnum value = values.get(name);
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
