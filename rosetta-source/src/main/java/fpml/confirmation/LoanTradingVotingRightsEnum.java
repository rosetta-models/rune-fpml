package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingVotingRightsEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list that specifies type of voting rights process, i.e. whether voting rights are passed along to buyer or retained by seller.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("LoanTradingVotingRightsEnum")
public enum LoanTradingVotingRightsEnum {

	/**
	 * Voting rights passed to the buyer
	 */
	@RosettaEnumValue(value = "PASSED_ON_TO_BUYER") 
	PASSED_ON_TO_BUYER("PASSED_ON_TO_BUYER", null),
	
	/**
	 * Voting rights retained by the seller
	 */
	@RosettaEnumValue(value = "RETAINED_BY_SELLER") 
	RETAINED_BY_SELLER("RETAINED_BY_SELLER", null)
;
	private static Map<String, LoanTradingVotingRightsEnum> values;
	static {
        Map<String, LoanTradingVotingRightsEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingVotingRightsEnum instance : LoanTradingVotingRightsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingVotingRightsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingVotingRightsEnum fromDisplayName(String name) {
		LoanTradingVotingRightsEnum value = values.get(name);
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
