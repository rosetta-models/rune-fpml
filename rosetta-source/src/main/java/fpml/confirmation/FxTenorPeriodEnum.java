package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxTenorPeriodEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("FxTenorPeriodEnum")
public enum FxTenorPeriodEnum {

	@RosettaEnumValue(value = "BROKEN") 
	BROKEN("BROKEN", null),
	
	@RosettaEnumValue(value = "TODAY") 
	TODAY("TODAY", null),
	
	@RosettaEnumValue(value = "TOMORROW") 
	TOMORROW("TOMORROW", null),
	
	@RosettaEnumValue(value = "TOMORROW_NEXT") 
	TOMORROW_NEXT("TOMORROW_NEXT", null),
	
	@RosettaEnumValue(value = "SPOT") 
	SPOT("SPOT", null),
	
	@RosettaEnumValue(value = "SPOT_NEXT") 
	SPOT_NEXT("SPOT_NEXT", null)
;
	private static Map<String, FxTenorPeriodEnum> values;
	static {
        Map<String, FxTenorPeriodEnum> map = new ConcurrentHashMap<>();
		for (FxTenorPeriodEnum instance : FxTenorPeriodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxTenorPeriodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxTenorPeriodEnum fromDisplayName(String name) {
		FxTenorPeriodEnum value = values.get(name);
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
