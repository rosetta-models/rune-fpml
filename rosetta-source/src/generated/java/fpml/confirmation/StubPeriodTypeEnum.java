package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.StubPeriodTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Element to define how to deal with a none standard calculation period within a swap stream.
 * @version ${project.version}
 */
@RosettaEnum("StubPeriodTypeEnum")
public enum StubPeriodTypeEnum {

	@RosettaEnumValue(value = "SHORT_INITIAL") 
	SHORT_INITIAL("SHORT_INITIAL", null),
	
	@RosettaEnumValue(value = "SHORT_FINAL") 
	SHORT_FINAL("SHORT_FINAL", null),
	
	@RosettaEnumValue(value = "LONG_INITIAL") 
	LONG_INITIAL("LONG_INITIAL", null),
	
	@RosettaEnumValue(value = "LONG_FINAL") 
	LONG_FINAL("LONG_FINAL", null)
;
	private static Map<String, StubPeriodTypeEnum> values;
	static {
        Map<String, StubPeriodTypeEnum> map = new ConcurrentHashMap<>();
		for (StubPeriodTypeEnum instance : StubPeriodTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	StubPeriodTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static StubPeriodTypeEnum fromDisplayName(String name) {
		StubPeriodTypeEnum value = values.get(name);
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
