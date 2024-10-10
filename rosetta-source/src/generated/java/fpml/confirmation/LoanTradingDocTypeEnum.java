package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingDocTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list describing the type of documentation used to settle a secondary market syndicated loan trade.
 * @version ${project.version}
 */
@RosettaEnum("LoanTradingDocTypeEnum")
public enum LoanTradingDocTypeEnum {

	/**
	 * Distressed loan trade documentation.
	 */
	@RosettaEnumValue(value = "DISTRESSED") 
	DISTRESSED("DISTRESSED", null),
	
	/**
	 * Par loan trade documentation.
	 */
	@RosettaEnumValue(value = "PAR") 
	PAR("PAR", null)
;
	private static Map<String, LoanTradingDocTypeEnum> values;
	static {
        Map<String, LoanTradingDocTypeEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingDocTypeEnum instance : LoanTradingDocTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingDocTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingDocTypeEnum fromDisplayName(String name) {
		LoanTradingDocTypeEnum value = values.get(name);
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
