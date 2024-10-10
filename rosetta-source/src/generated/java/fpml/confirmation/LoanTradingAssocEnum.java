package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingAssocEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list that defines the loan trading association responsible for defining the standardized legal framework that governs the trade.
 * @version ${project.version}
 */
@RosettaEnum("LoanTradingAssocEnum")
public enum LoanTradingAssocEnum {

	/**
	 * Loan Market Association (UK).
	 */
	@RosettaEnumValue(value = "LMA") 
	LMA("LMA", null),
	
	/**
	 * The Loan Syndications and Trading Association (US).
	 */
	@RosettaEnumValue(value = "LSTA") 
	LSTA("LSTA", null)
;
	private static Map<String, LoanTradingAssocEnum> values;
	static {
        Map<String, LoanTradingAssocEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingAssocEnum instance : LoanTradingAssocEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingAssocEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingAssocEnum fromDisplayName(String name) {
		LoanTradingAssocEnum value = values.get(name);
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
