package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.CommodityReturnCalculationFormulaEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("CommodityReturnCalculationFormulaEnum")
public enum CommodityReturnCalculationFormulaEnum {

	@RosettaEnumValue(value = "SIMPLE_FORMULA") 
	SIMPLE_FORMULA("SIMPLE_FORMULA", null),
	
	@RosettaEnumValue(value = "COMPOUND_FORMULA") 
	COMPOUND_FORMULA("COMPOUND_FORMULA", null)
;
	private static Map<String, CommodityReturnCalculationFormulaEnum> values;
	static {
        Map<String, CommodityReturnCalculationFormulaEnum> map = new ConcurrentHashMap<>();
		for (CommodityReturnCalculationFormulaEnum instance : CommodityReturnCalculationFormulaEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityReturnCalculationFormulaEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityReturnCalculationFormulaEnum fromDisplayName(String name) {
		CommodityReturnCalculationFormulaEnum value = values.get(name);
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
