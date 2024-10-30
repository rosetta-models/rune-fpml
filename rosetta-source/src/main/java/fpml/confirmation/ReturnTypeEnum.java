package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.ReturnTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("ReturnTypeEnum")
public enum ReturnTypeEnum {

	@RosettaEnumValue(value = "DIVIDEND") 
	DIVIDEND("DIVIDEND", null),
	
	@RosettaEnumValue(value = "PRICE") 
	PRICE("PRICE", null),
	
	@RosettaEnumValue(value = "TOTAL") 
	TOTAL("TOTAL", null)
;
	private static Map<String, ReturnTypeEnum> values;
	static {
        Map<String, ReturnTypeEnum> map = new ConcurrentHashMap<>();
		for (ReturnTypeEnum instance : ReturnTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReturnTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReturnTypeEnum fromDisplayName(String name) {
		ReturnTypeEnum value = values.get(name);
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
