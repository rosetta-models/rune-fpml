package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.QuotationRateTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("QuotationRateTypeEnum")
public enum QuotationRateTypeEnum {

	@RosettaEnumValue(value = "BID") 
	BID("BID", null),
	
	@RosettaEnumValue(value = "ASK") 
	ASK("ASK", null),
	
	@RosettaEnumValue(value = "MID") 
	MID("MID", null),
	
	@RosettaEnumValue(value = "EXERCISING_PARTY_PAYS") 
	EXERCISING_PARTY_PAYS("EXERCISING_PARTY_PAYS", null)
;
	private static Map<String, QuotationRateTypeEnum> values;
	static {
        Map<String, QuotationRateTypeEnum> map = new ConcurrentHashMap<>();
		for (QuotationRateTypeEnum instance : QuotationRateTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	QuotationRateTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static QuotationRateTypeEnum fromDisplayName(String name) {
		QuotationRateTypeEnum value = values.get(name);
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
