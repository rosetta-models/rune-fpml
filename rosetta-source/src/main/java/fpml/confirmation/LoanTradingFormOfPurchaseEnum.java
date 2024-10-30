package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.LoanTradingFormOfPurchaseEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A list describing forms of purchase.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("LoanTradingFormOfPurchaseEnum")
public enum LoanTradingFormOfPurchaseEnum {

	@RosettaEnumValue(value = "ASSIGNMENT") 
	ASSIGNMENT("ASSIGNMENT", null),
	
	@RosettaEnumValue(value = "ASSIGNMENT_ONLY") 
	ASSIGNMENT_ONLY("ASSIGNMENT_ONLY", null),
	
	@RosettaEnumValue(value = "OTHER") 
	OTHER("OTHER", null),
	
	@RosettaEnumValue(value = "LMAFUNDED_PARTICIPATION") 
	LMAFUNDED_PARTICIPATION("LMAFUNDED_PARTICIPATION", null),
	
	@RosettaEnumValue(value = "LMAFUNDED_RISK_PARTICIPATION") 
	LMAFUNDED_RISK_PARTICIPATION("LMAFUNDED_RISK_PARTICIPATION", null),
	
	@RosettaEnumValue(value = "LMARISK_PARTICIPATION") 
	LMARISK_PARTICIPATION("LMARISK_PARTICIPATION", null),
	
	@RosettaEnumValue(value = "LMARISK_TO_FUNDED_PARTICIPATION") 
	LMARISK_TO_FUNDED_PARTICIPATION("LMARISK_TO_FUNDED_PARTICIPATION", null),
	
	@RosettaEnumValue(value = "LMATRANSFER_AGREEMENT") 
	LMATRANSFER_AGREEMENT("LMATRANSFER_AGREEMENT", null),
	
	@RosettaEnumValue(value = "LMATRANSFER_CERTIFICATE") 
	LMATRANSFER_CERTIFICATE("LMATRANSFER_CERTIFICATE", null),
	
	@RosettaEnumValue(value = "PARTICIPATION") 
	PARTICIPATION("PARTICIPATION", null)
;
	private static Map<String, LoanTradingFormOfPurchaseEnum> values;
	static {
        Map<String, LoanTradingFormOfPurchaseEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingFormOfPurchaseEnum instance : LoanTradingFormOfPurchaseEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingFormOfPurchaseEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingFormOfPurchaseEnum fromDisplayName(String name) {
		LoanTradingFormOfPurchaseEnum value = values.get(name);
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
