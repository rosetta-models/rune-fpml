package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.PriceExpressionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("PriceExpressionEnum")
public enum PriceExpressionEnum {

	@RosettaEnumValue(value = "ABSOLUTE_TERMS") 
	ABSOLUTE_TERMS("ABSOLUTE_TERMS", null),
	
	@RosettaEnumValue(value = "PERCENTAGE_OF_NOTIONAL") 
	PERCENTAGE_OF_NOTIONAL("PERCENTAGE_OF_NOTIONAL", null)
;
	private static Map<String, PriceExpressionEnum> values;
	static {
        Map<String, PriceExpressionEnum> map = new ConcurrentHashMap<>();
		for (PriceExpressionEnum instance : PriceExpressionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PriceExpressionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PriceExpressionEnum fromDisplayName(String name) {
		PriceExpressionEnum value = values.get(name);
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
