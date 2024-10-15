package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list that specifies whether a trade was executed during the syndication period or in the post-syndication market.
 * @version ${project.version}
 */
@RosettaEnum("LoanTradingTypeEnum")
public enum LoanTradingTypeEnum {

	/**
	 * Trade is part of a syndication.
	 */
	@RosettaEnumValue(value = "PRIMARY") 
	PRIMARY("PRIMARY", null),
	
	/**
	 * Trade was performed in the secondary (non-syndication) market.
	 */
	@RosettaEnumValue(value = "SECONDARY") 
	SECONDARY("SECONDARY", null)
;
	private static Map<String, LoanTradingTypeEnum> values;
	static {
        Map<String, LoanTradingTypeEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingTypeEnum instance : LoanTradingTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingTypeEnum fromDisplayName(String name) {
		LoanTradingTypeEnum value = values.get(name);
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
