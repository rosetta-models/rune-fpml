package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.EnvironmentalAbandonmentOfSchemeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Upon the occurrence of an Abandonment of Scheme, as defined in clause (h)(iv) of the Emissions Annex, one of the following elections, the specific terms of which are set forth in clause (b)(iii) of the Emissions Annex, will govern the parties’ rights and obligations with respect to this Emissions Transaction. If none of the above options is selected, Option A(1) will apply.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("EnvironmentalAbandonmentOfSchemeEnum")
public enum EnvironmentalAbandonmentOfSchemeEnum {

	/**
	 * Abandonment of Scheme constitutes an Additional Termination Event.
	 */
	@RosettaEnumValue(value = "OPTION_A_1") 
	OPTION_A_1("OPTION_A_1", null),
	
	/**
	 * Abandonment of Scheme entails no further obligations.
	 */
	@RosettaEnumValue(value = "OPTION_A_2") 
	OPTION_A_2("OPTION_A_2", null),
	
	/**
	 * The applicability of Abandonment of Scheme to Emissions Transactions is set forth in the applicable Confirmation.
	 */
	@RosettaEnumValue(value = "OPTION_B") 
	OPTION_B("OPTION_B", null),
	
	/**
	 * The applicability of Abandonment of Scheme does not apply.
	 */
	@RosettaEnumValue(value = "OPTION_C") 
	OPTION_C("OPTION_C", null)
;
	private static Map<String, EnvironmentalAbandonmentOfSchemeEnum> values;
	static {
        Map<String, EnvironmentalAbandonmentOfSchemeEnum> map = new ConcurrentHashMap<>();
		for (EnvironmentalAbandonmentOfSchemeEnum instance : EnvironmentalAbandonmentOfSchemeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EnvironmentalAbandonmentOfSchemeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EnvironmentalAbandonmentOfSchemeEnum fromDisplayName(String name) {
		EnvironmentalAbandonmentOfSchemeEnum value = values.get(name);
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
