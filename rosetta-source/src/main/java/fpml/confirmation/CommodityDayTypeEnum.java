package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CommodityDayTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("CommodityDayTypeEnum")
public enum CommodityDayTypeEnum {

	@RosettaEnumValue(value = "BUSINESS") 
	BUSINESS("BUSINESS", null),
	
	@RosettaEnumValue(value = "CALENDAR") 
	CALENDAR("CALENDAR", null),
	
	@RosettaEnumValue(value = "COMMODITY_BUSINESS") 
	COMMODITY_BUSINESS("COMMODITY_BUSINESS", null),
	
	@RosettaEnumValue(value = "CURRENCY_BUSINESS") 
	CURRENCY_BUSINESS("CURRENCY_BUSINESS", null),
	
	@RosettaEnumValue(value = "EXCHANGE_BUSINESS") 
	EXCHANGE_BUSINESS("EXCHANGE_BUSINESS", null),
	
	@RosettaEnumValue(value = "SCHEDULED_TRADING_DAY") 
	SCHEDULED_TRADING_DAY("SCHEDULED_TRADING_DAY", null),
	
	@RosettaEnumValue(value = "GAS_FLOW") 
	GAS_FLOW("GAS_FLOW", null),
	
	@RosettaEnumValue(value = "NEARBY_CONTRACT_DAY") 
	NEARBY_CONTRACT_DAY("NEARBY_CONTRACT_DAY", null)
;
	private static Map<String, CommodityDayTypeEnum> values;
	static {
        Map<String, CommodityDayTypeEnum> map = new ConcurrentHashMap<>();
		for (CommodityDayTypeEnum instance : CommodityDayTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityDayTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityDayTypeEnum fromDisplayName(String name) {
		CommodityDayTypeEnum value = values.get(name);
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
