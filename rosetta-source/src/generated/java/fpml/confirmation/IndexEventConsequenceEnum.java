package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.IndexEventConsequenceEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("IndexEventConsequenceEnum")
public enum IndexEventConsequenceEnum {

	@RosettaEnumValue(value = "CALCULATION_AGENT_ADJUSTMENT") 
	CALCULATION_AGENT_ADJUSTMENT("CALCULATION_AGENT_ADJUSTMENT", null),
	
	@RosettaEnumValue(value = "NEGOTIATED_CLOSE_OUT") 
	NEGOTIATED_CLOSE_OUT("NEGOTIATED_CLOSE_OUT", null),
	
	@RosettaEnumValue(value = "CANCELLATION_AND_PAYMENT") 
	CANCELLATION_AND_PAYMENT("CANCELLATION_AND_PAYMENT", null),
	
	@RosettaEnumValue(value = "RELATED_EXCHANGE") 
	RELATED_EXCHANGE("RELATED_EXCHANGE", null)
;
	private static Map<String, IndexEventConsequenceEnum> values;
	static {
        Map<String, IndexEventConsequenceEnum> map = new ConcurrentHashMap<>();
		for (IndexEventConsequenceEnum instance : IndexEventConsequenceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	IndexEventConsequenceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static IndexEventConsequenceEnum fromDisplayName(String name) {
		IndexEventConsequenceEnum value = values.get(name);
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
