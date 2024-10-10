package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ObligationCategoryEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ObligationCategoryEnum")
public enum ObligationCategoryEnum {

	@RosettaEnumValue(value = "PAYMENT") 
	PAYMENT("PAYMENT", null),
	
	@RosettaEnumValue(value = "BORROWED_MONEY") 
	BORROWED_MONEY("BORROWED_MONEY", null),
	
	@RosettaEnumValue(value = "REFERENCE_OBLIGATIONS_ONLY") 
	REFERENCE_OBLIGATIONS_ONLY("REFERENCE_OBLIGATIONS_ONLY", null),
	
	@RosettaEnumValue(value = "BOND") 
	BOND("BOND", null),
	
	@RosettaEnumValue(value = "LOAN") 
	LOAN("LOAN", null),
	
	@RosettaEnumValue(value = "BOND_OR_LOAN") 
	BOND_OR_LOAN("BOND_OR_LOAN", null)
;
	private static Map<String, ObligationCategoryEnum> values;
	static {
        Map<String, ObligationCategoryEnum> map = new ConcurrentHashMap<>();
		for (ObligationCategoryEnum instance : ObligationCategoryEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ObligationCategoryEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ObligationCategoryEnum fromDisplayName(String name) {
		ObligationCategoryEnum value = values.get(name);
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
