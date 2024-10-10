package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.NotionalChangeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indicator as to the type of transaction in accordance with Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014.
 * @version ${project.version}
 */
@RosettaEnum("NotionalChangeEnum")
public enum NotionalChangeEnum {

	/**
	 * Transaction results in a Increase of Notional value
	 */
	@RosettaEnumValue(value = "INCREASE") 
	INCREASE("INCREASE", null),
	
	/**
	 * Transaction results in a Decrease of Notional value
	 */
	@RosettaEnumValue(value = "DECREASE") 
	DECREASE("DECREASE", null)
;
	private static Map<String, NotionalChangeEnum> values;
	static {
        Map<String, NotionalChangeEnum> map = new ConcurrentHashMap<>();
		for (NotionalChangeEnum instance : NotionalChangeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotionalChangeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotionalChangeEnum fromDisplayName(String name) {
		NotionalChangeEnum value = values.get(name);
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
