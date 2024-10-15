package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CommodityBullionSettlementDisruptionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CommodityBullionSettlementDisruptionEnum")
public enum CommodityBullionSettlementDisruptionEnum {

	@RosettaEnumValue(value = "NEGOTIATION") 
	NEGOTIATION("NEGOTIATION", null),
	
	@RosettaEnumValue(value = "CANCELLATION_AND_PAYMENT") 
	CANCELLATION_AND_PAYMENT("CANCELLATION_AND_PAYMENT", null)
;
	private static Map<String, CommodityBullionSettlementDisruptionEnum> values;
	static {
        Map<String, CommodityBullionSettlementDisruptionEnum> map = new ConcurrentHashMap<>();
		for (CommodityBullionSettlementDisruptionEnum instance : CommodityBullionSettlementDisruptionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityBullionSettlementDisruptionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityBullionSettlementDisruptionEnum fromDisplayName(String name) {
		CommodityBullionSettlementDisruptionEnum value = values.get(name);
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
