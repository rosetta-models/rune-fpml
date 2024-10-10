package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FxAccrualKnockoutBarrierRetentionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of a knockout barrier used in an accrual product (e.g. American or European)
 * @version ${project.version}
 */
@RosettaEnum("FxAccrualKnockoutBarrierRetentionEnum")
public enum FxAccrualKnockoutBarrierRetentionEnum {

	/**
	 * If the barrier is triggered, the accrual process for that period stops. The parties retain the underlying settlement rights for that period with the currently accrued notional.
	 */
	@RosettaEnumValue(value = "KEEP") 
	KEEP("KEEP", null),
	
	/**
	 * If the barrier is triggered, the accrual process for that period stops. No settlement occurs for that period.
	 */
	@RosettaEnumValue(value = "LOSE") 
	LOSE("LOSE", null)
;
	private static Map<String, FxAccrualKnockoutBarrierRetentionEnum> values;
	static {
        Map<String, FxAccrualKnockoutBarrierRetentionEnum> map = new ConcurrentHashMap<>();
		for (FxAccrualKnockoutBarrierRetentionEnum instance : FxAccrualKnockoutBarrierRetentionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxAccrualKnockoutBarrierRetentionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxAccrualKnockoutBarrierRetentionEnum fromDisplayName(String name) {
		FxAccrualKnockoutBarrierRetentionEnum value = values.get(name);
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
