package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.StepRelativeToEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The specification of whether a percentage rate change, used to calculate a change in notional outstanding, is expressed as a percentage of the initial notional amount or the previously outstanding notional amount.
 * @version ${project.version}
 */
@RosettaEnum("StepRelativeToEnum")
public enum StepRelativeToEnum {

	@RosettaEnumValue(value = "INITIAL") 
	INITIAL("INITIAL", null),
	
	@RosettaEnumValue(value = "PREVIOUS") 
	PREVIOUS("PREVIOUS", null)
;
	private static Map<String, StepRelativeToEnum> values;
	static {
        Map<String, StepRelativeToEnum> map = new ConcurrentHashMap<>();
		for (StepRelativeToEnum instance : StepRelativeToEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	StepRelativeToEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static StepRelativeToEnum fromDisplayName(String name) {
		StepRelativeToEnum value = values.get(name);
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
