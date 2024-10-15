package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DividendDateReferenceEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DividendDateReferenceEnum")
public enum DividendDateReferenceEnum {

	@RosettaEnumValue(value = "EX_DATE") 
	EX_DATE("EX_DATE", null),
	
	@RosettaEnumValue(value = "DIVIDEND_PAYMENT_DATE") 
	DIVIDEND_PAYMENT_DATE("DIVIDEND_PAYMENT_DATE", null),
	
	@RosettaEnumValue(value = "DIVIDEND_VALUATION_DATE") 
	DIVIDEND_VALUATION_DATE("DIVIDEND_VALUATION_DATE", null),
	
	@RosettaEnumValue(value = "RECORD_DATE") 
	RECORD_DATE("RECORD_DATE", null),
	
	@RosettaEnumValue(value = "TERMINATION_DATE") 
	TERMINATION_DATE("TERMINATION_DATE", null),
	
	@RosettaEnumValue(value = "EQUITY_PAYMENT_DATE") 
	EQUITY_PAYMENT_DATE("EQUITY_PAYMENT_DATE", null),
	
	@RosettaEnumValue(value = "FOLLOWING_PAYMENT_DATE") 
	FOLLOWING_PAYMENT_DATE("FOLLOWING_PAYMENT_DATE", null),
	
	@RosettaEnumValue(value = "AD_HOC_DATE") 
	AD_HOC_DATE("AD_HOC_DATE", null),
	
	@RosettaEnumValue(value = "CUMULATIVE_EQUITY_PAID") 
	CUMULATIVE_EQUITY_PAID("CUMULATIVE_EQUITY_PAID", null),
	
	@RosettaEnumValue(value = "CUMULATIVE_LIBOR_PAID") 
	CUMULATIVE_LIBOR_PAID("CUMULATIVE_LIBOR_PAID", null),
	
	@RosettaEnumValue(value = "CUMULATIVE_EQUITY_EX_DIV") 
	CUMULATIVE_EQUITY_EX_DIV("CUMULATIVE_EQUITY_EX_DIV", null),
	
	@RosettaEnumValue(value = "CUMULATIVE_LIBOR_EX_DIV") 
	CUMULATIVE_LIBOR_EX_DIV("CUMULATIVE_LIBOR_EX_DIV", null),
	
	@RosettaEnumValue(value = "SHARE_PAYMENT") 
	SHARE_PAYMENT("SHARE_PAYMENT", null),
	
	@RosettaEnumValue(value = "CASH_SETTLEMENT_PAYMENT_DATE") 
	CASH_SETTLEMENT_PAYMENT_DATE("CASH_SETTLEMENT_PAYMENT_DATE", null),
	
	@RosettaEnumValue(value = "FLOATING_AMOUNT_PAYMENT_DATE") 
	FLOATING_AMOUNT_PAYMENT_DATE("FLOATING_AMOUNT_PAYMENT_DATE", null),
	
	@RosettaEnumValue(value = "CASH_SETTLE_PAYMENT_DATE_EX_DIV") 
	CASH_SETTLE_PAYMENT_DATE_EX_DIV("CASH_SETTLE_PAYMENT_DATE_EX_DIV", null),
	
	@RosettaEnumValue(value = "CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT") 
	CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT("CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT", null),
	
	@RosettaEnumValue(value = "EX_DIVIDEND_PAYMENT_DATE") 
	EX_DIVIDEND_PAYMENT_DATE("EX_DIVIDEND_PAYMENT_DATE", null)
;
	private static Map<String, DividendDateReferenceEnum> values;
	static {
        Map<String, DividendDateReferenceEnum> map = new ConcurrentHashMap<>();
		for (DividendDateReferenceEnum instance : DividendDateReferenceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendDateReferenceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendDateReferenceEnum fromDisplayName(String name) {
		DividendDateReferenceEnum value = values.get(name);
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
