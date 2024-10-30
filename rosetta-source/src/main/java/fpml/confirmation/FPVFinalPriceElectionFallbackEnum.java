package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.FPVFinalPriceElectionFallbackEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("FPVFinalPriceElectionFallbackEnum")
public enum FPVFinalPriceElectionFallbackEnum {

	@RosettaEnumValue(value = "FPVCLOSE") 
	FPVCLOSE("FPVCLOSE", null),
	
	@RosettaEnumValue(value = "FPVHEDGE_EXECUTION") 
	FPVHEDGE_EXECUTION("FPVHEDGE_EXECUTION", null)
;
	private static Map<String, FPVFinalPriceElectionFallbackEnum> values;
	static {
        Map<String, FPVFinalPriceElectionFallbackEnum> map = new ConcurrentHashMap<>();
		for (FPVFinalPriceElectionFallbackEnum instance : FPVFinalPriceElectionFallbackEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FPVFinalPriceElectionFallbackEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FPVFinalPriceElectionFallbackEnum fromDisplayName(String name) {
		FPVFinalPriceElectionFallbackEnum value = values.get(name);
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
