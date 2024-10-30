package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.SpecifiedPriceEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("SpecifiedPriceEnum")
public enum SpecifiedPriceEnum {

	/**
	 * The Specified Price shall be the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "AFTERNOON") 
	AFTERNOON("AFTERNOON", null),
	
	/**
	 * The Specified Price shall be the Ask price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "ASK") 
	ASK("ASK", null),
	
	/**
	 * The Specified Price shall be the Bid price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "BID") 
	BID("BID", null),
	
	/**
	 * The Specified Price shall be the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "CLOSING") 
	CLOSING("CLOSING", null),
	
	/**
	 * The Specified Price shall be the High price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "HIGH") 
	HIGH("HIGH", null),
	
	/**
	 * The Specified Price shall be the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "INDEX") 
	INDEX("INDEX", null),
	
	/**
	 * The Specified Price shall be the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "MEAN_OF_BID_AND_ASK") 
	MEAN_OF_BID_AND_ASK("MEAN_OF_BID_AND_ASK", null),
	
	/**
	 * The Specified Price shall be the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "LOCATIONAL_MARGINAL") 
	LOCATIONAL_MARGINAL("LOCATIONAL_MARGINAL", null),
	
	/**
	 * The Specified Price shall be the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "LOW") 
	LOW("LOW", null),
	
	/**
	 * The Specified Price shall be the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "MARGINAL_HOURLY") 
	MARGINAL_HOURLY("MARGINAL_HOURLY", null),
	
	/**
	 * The Specified Price shall be the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "MARKET_CLEARING") 
	MARKET_CLEARING("MARKET_CLEARING", null),
	
	/**
	 * The Specified Price shall be the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "MEAN_OF_HIGH_AND_LOW") 
	MEAN_OF_HIGH_AND_LOW("MEAN_OF_HIGH_AND_LOW", null),
	
	/**
	 * The Specified Price shall be the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "MORNING") 
	MORNING("MORNING", null),
	
	/**
	 * The Specified Price shall be the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "OFFICIAL") 
	OFFICIAL("OFFICIAL", null),
	
	/**
	 * The Specified Price shall be the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "OPENING") 
	OPENING("OPENING", null),
	
	/**
	 * The Specified Price shall be the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "OSP") 
	OSP("OSP", null),
	
	/**
	 * The Specified Price shall be the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "SETTLEMENT") 
	SETTLEMENT("SETTLEMENT", null),
	
	/**
	 * The Specified Price shall be the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "SPOT") 
	SPOT("SPOT", null),
	
	/**
	 * The Specified Price shall be the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "MIDPOINT") 
	MIDPOINT("MIDPOINT", null),
	
	/**
	 * The Specified Price shall be the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "NATIONAL_SINGLE") 
	NATIONAL_SINGLE("NATIONAL_SINGLE", null),
	
	/**
	 * The Specified Price shall be the Volume Weighted Average of prices effective on the Pricing Date reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "WEIGHTED_AVERAGE") 
	WEIGHTED_AVERAGE("WEIGHTED_AVERAGE", null),
	
	/**
	 * The Specified Price shall be the Non-volume Weighted Average of prices effective on the Pricing Date reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 */
	@RosettaEnumValue(value = "UN_WEIGHTED_AVERAGE") 
	UN_WEIGHTED_AVERAGE("UN_WEIGHTED_AVERAGE", null)
;
	private static Map<String, SpecifiedPriceEnum> values;
	static {
        Map<String, SpecifiedPriceEnum> map = new ConcurrentHashMap<>();
		for (SpecifiedPriceEnum instance : SpecifiedPriceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SpecifiedPriceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SpecifiedPriceEnum fromDisplayName(String name) {
		SpecifiedPriceEnum value = values.get(name);
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
