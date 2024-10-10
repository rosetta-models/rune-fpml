package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.AveragingMethodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The method of calculation to be used when averaging rates. Per ISDA 2000 Definitions, Section 6.2. Certain Definitions Relating to Floating Amounts.
 * @version ${project.version}
 */
@RosettaEnum("AveragingMethodEnum")
public enum AveragingMethodEnum {

	@RosettaEnumValue(value = "UNWEIGHTED") 
	UNWEIGHTED("UNWEIGHTED", null),
	
	@RosettaEnumValue(value = "WEIGHTED") 
	WEIGHTED("WEIGHTED", null)
;
	private static Map<String, AveragingMethodEnum> values;
	static {
        Map<String, AveragingMethodEnum> map = new ConcurrentHashMap<>();
		for (AveragingMethodEnum instance : AveragingMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AveragingMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AveragingMethodEnum fromDisplayName(String name) {
		AveragingMethodEnum value = values.get(name);
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
