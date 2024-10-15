package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.GasProductTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of gas product.
 * @version ${project.version}
 */
@RosettaEnum("GasProductTypeEnum")
public enum GasProductTypeEnum {

	@RosettaEnumValue(value = "BUTANE") 
	BUTANE("BUTANE", null),
	
	@RosettaEnumValue(value = "CARBON_DIOXIDE") 
	CARBON_DIOXIDE("CARBON_DIOXIDE", null),
	
	@RosettaEnumValue(value = "EPMIX") 
	EPMIX("EPMIX", null),
	
	@RosettaEnumValue(value = "ETHANE") 
	ETHANE("ETHANE", null),
	
	@RosettaEnumValue(value = "GASOLINE") 
	GASOLINE("GASOLINE", null),
	
	@RosettaEnumValue(value = "HELIUM") 
	HELIUM("HELIUM", null),
	
	@RosettaEnumValue(value = "HYDROGEN_SULFIDE") 
	HYDROGEN_SULFIDE("HYDROGEN_SULFIDE", null),
	
	@RosettaEnumValue(value = "ISOBUTANE") 
	ISOBUTANE("ISOBUTANE", null),
	
	@RosettaEnumValue(value = "METHANE") 
	METHANE("METHANE", null),
	
	@RosettaEnumValue(value = "NAPHTHA") 
	NAPHTHA("NAPHTHA", null),
	
	@RosettaEnumValue(value = "NATURAL_GAS") 
	NATURAL_GAS("NATURAL_GAS", null),
	
	@RosettaEnumValue(value = "NITROGEN") 
	NITROGEN("NITROGEN", null),
	
	@RosettaEnumValue(value = "PENTANE") 
	PENTANE("PENTANE", null),
	
	@RosettaEnumValue(value = "PROPANE") 
	PROPANE("PROPANE", null),
	
	@RosettaEnumValue(value = "PROPYLENE") 
	PROPYLENE("PROPYLENE", null),
	
	@RosettaEnumValue(value = "WATER") 
	WATER("WATER", null)
;
	private static Map<String, GasProductTypeEnum> values;
	static {
        Map<String, GasProductTypeEnum> map = new ConcurrentHashMap<>();
		for (GasProductTypeEnum instance : GasProductTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	GasProductTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static GasProductTypeEnum fromDisplayName(String name) {
		GasProductTypeEnum value = values.get(name);
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
