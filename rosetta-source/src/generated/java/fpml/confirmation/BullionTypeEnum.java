package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.BullionTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines which type of bullion is applicable for a Bullion Transaction.
 * @version ${project.version}
 */
@RosettaEnum("BullionTypeEnum")
public enum BullionTypeEnum {

	/**
	 * Gold. Quality as per the Good Delivery Rules issued by the London Bullion Market Association.
	 */
	@RosettaEnumValue(value = "GOLD") 
	GOLD("GOLD", null),
	
	/**
	 * Palladium. Quality as per the Good Delivery Rules issued by the London Platinum and Palladium Market.
	 */
	@RosettaEnumValue(value = "PALLADIUM") 
	PALLADIUM("PALLADIUM", null),
	
	/**
	 * Palladium. Quality as per the Good Delivery Rules issued by the London Platinum and Palladium Market.
	 */
	@RosettaEnumValue(value = "PLATINUM") 
	PLATINUM("PLATINUM", null),
	
	/**
	 * Silver. Quality as per the Good Delivery Rules issued by the London Bullion Market Association.
	 */
	@RosettaEnumValue(value = "SILVER") 
	SILVER("SILVER", null),
	
	/**
	 * Quality as per the Good Delivery Rules for Rhodium.
	 */
	@RosettaEnumValue(value = "RHODIUM") 
	RHODIUM("RHODIUM", null),
	
	@RosettaEnumValue(value = "RHODIUM_SPONGE") 
	RHODIUM_SPONGE("RHODIUM_SPONGE", null),
	
	/**
	 * Quality as per the Good Delivery Rules for Iridium.
	 */
	@RosettaEnumValue(value = "IRIDIUM") 
	IRIDIUM("IRIDIUM", null),
	
	/**
	 * Quality as per the Good Delivery Rules for Ruthenium.
	 */
	@RosettaEnumValue(value = "RUTHENIUM") 
	RUTHENIUM("RUTHENIUM", null),
	
	/**
	 * Quality as per the Good Delivery Rules for Osmium.
	 */
	@RosettaEnumValue(value = "OSMIUM") 
	OSMIUM("OSMIUM", null)
;
	private static Map<String, BullionTypeEnum> values;
	static {
        Map<String, BullionTypeEnum> map = new ConcurrentHashMap<>();
		for (BullionTypeEnum instance : BullionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BullionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BullionTypeEnum fromDisplayName(String name) {
		BullionTypeEnum value = values.get(name);
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
