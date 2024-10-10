package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CommodityPayRelativeToEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CommodityPayRelativeToEnum")
public enum CommodityPayRelativeToEnum {

	@RosettaEnumValue(value = "CALCULATION_PERIOD_START_DATE") 
	CALCULATION_PERIOD_START_DATE("CALCULATION_PERIOD_START_DATE", null),
	
	@RosettaEnumValue(value = "CALCULATION_PERIOD_END_DATE") 
	CALCULATION_PERIOD_END_DATE("CALCULATION_PERIOD_END_DATE", null),
	
	@RosettaEnumValue(value = "LAST_PRICING_DATE") 
	LAST_PRICING_DATE("LAST_PRICING_DATE", null),
	
	@RosettaEnumValue(value = "RESET_DATE") 
	RESET_DATE("RESET_DATE", null),
	
	@RosettaEnumValue(value = "VALUATION_DATE") 
	VALUATION_DATE("VALUATION_DATE", null),
	
	@RosettaEnumValue(value = "CALCULATION_DATE") 
	CALCULATION_DATE("CALCULATION_DATE", null),
	
	@RosettaEnumValue(value = "CALCULATION_PERIOD_MONTH_END") 
	CALCULATION_PERIOD_MONTH_END("CALCULATION_PERIOD_MONTH_END", null),
	
	@RosettaEnumValue(value = "CALCULATION_PERIOD_MONTH_START") 
	CALCULATION_PERIOD_MONTH_START("CALCULATION_PERIOD_MONTH_START", null),
	
	@RosettaEnumValue(value = "EFFECTIVE_DATE") 
	EFFECTIVE_DATE("EFFECTIVE_DATE", null),
	
	@RosettaEnumValue(value = "PRICING_PERIOD_MONTH_END") 
	PRICING_PERIOD_MONTH_END("PRICING_PERIOD_MONTH_END", null),
	
	@RosettaEnumValue(value = "TERMINATION_OR_EXPIRATION_DATE") 
	TERMINATION_OR_EXPIRATION_DATE("TERMINATION_OR_EXPIRATION_DATE", null),
	
	@RosettaEnumValue(value = "TRADE_DATE") 
	TRADE_DATE("TRADE_DATE", null),
	
	@RosettaEnumValue(value = "PRICING_PERIOD_END_OF_WEEK") 
	PRICING_PERIOD_END_OF_WEEK("PRICING_PERIOD_END_OF_WEEK", null),
	
	@RosettaEnumValue(value = "FIRST_PRICING_DATE") 
	FIRST_PRICING_DATE("FIRST_PRICING_DATE", null)
;
	private static Map<String, CommodityPayRelativeToEnum> values;
	static {
        Map<String, CommodityPayRelativeToEnum> map = new ConcurrentHashMap<>();
		for (CommodityPayRelativeToEnum instance : CommodityPayRelativeToEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityPayRelativeToEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityPayRelativeToEnum fromDisplayName(String name) {
		CommodityPayRelativeToEnum value = values.get(name);
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
