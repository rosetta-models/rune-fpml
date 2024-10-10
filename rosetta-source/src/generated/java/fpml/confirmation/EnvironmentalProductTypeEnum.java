package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.EnvironmentalProductTypeEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Environmental Product (e.g. allowance, certificate or unit).
 * @version ${project.version}
 */
@RosettaEnum("EnvironmentalProductTypeEnum")
public enum EnvironmentalProductTypeEnum {

	/**
	 * For EU Emissions Allowance Transactions: An EU Emissions Allowance.
	 */
	@RosettaEnumValue(value = "EUALLOWANCE") 
	EUALLOWANCE("EUALLOWANCE", null),
	
	/**
	 * For EU Emissions Allowance Transactions: An EU Emissions Credit.
	 */
	@RosettaEnumValue(value = "EUCREDIT") 
	EUCREDIT("EUCREDIT", null),
	
	/**
	 * For EU Emissions Allowance Transactions: An EU Alternative Allowance.
	 */
	@RosettaEnumValue(value = "ALTERNATIVE_ALLOWANCE") 
	ALTERNATIVE_ALLOWANCE("ALTERNATIVE_ALLOWANCE", null),
	
	/**
	 * For US Emissions Allowance Transactions: A limited authorization issued by the state permitting authority or the US Environmental Protection Agency (EPA) to emit certain amounts of nitrogen oxides (Nox).
	 */
	@RosettaEnumValue(value = "NOXEMISSIONS_PRODUCT") 
	NOXEMISSIONS_PRODUCT("NOXEMISSIONS_PRODUCT", null),
	
	/**
	 * For US Emissions Allowance Transactions: A emissions allowance or emissions reduction credit issued under a mult-state or provincial or other cap-and-trade Scheme.
	 */
	@RosettaEnumValue(value = "REGIONAL_EMISSIONS_PRODUCT") 
	REGIONAL_EMISSIONS_PRODUCT("REGIONAL_EMISSIONS_PRODUCT", null),
	
	/**
	 * For US Emissions Allowance Transactions: A limited authorization issued by the RGGI scheme permitting the emission of certain amounts of carbon dioxide.
	 */
	@RosettaEnumValue(value = "RGGIEMISSIONS_PRODUCT") 
	RGGIEMISSIONS_PRODUCT("RGGIEMISSIONS_PRODUCT", null),
	
	/**
	 * For US Emissions Allowance Transactions: A limited authorization issued by the U.S. Environmental Protection Agency (EPA) to emit a certain amount of sulfur dioxide.
	 */
	@RosettaEnumValue(value = "SO2_EMISSIONS_PRODUCT") 
	SO2_EMISSIONS_PRODUCT("SO2_EMISSIONS_PRODUCT", null),
	
	/**
	 * For US Emissions Allowance Transactions: Any emissions allowance or emission reduction credit created and promulgated under a U.S. state Scheme.
	 */
	@RosettaEnumValue(value = "STATE_EMISSION_PRODUCT") 
	STATE_EMISSION_PRODUCT("STATE_EMISSION_PRODUCT", null),
	
	/**
	 * For US Emissions Allowance Transactions: Any emissions allowance, emission credit, emissions offset or emissions reduction credit created or issued under a voluntary Scheme.
	 */
	@RosettaEnumValue(value = "VOLUNTARY_EMISSION_PRODUCT") 
	VOLUNTARY_EMISSION_PRODUCT("VOLUNTARY_EMISSION_PRODUCT", null),
	
	/**
	 * For US Renewable Energy Certificate Transactions: A Renewable Energy Certificate (“REC”) represents the environmental, social and other non-power qualities of generation of 1 megawatt-hour (MWh) of electricity from an eligible renewable energy resource.
	 */
	@RosettaEnumValue(value = "RENEWABLE_ENERGY_CERTIFICATE") 
	RENEWABLE_ENERGY_CERTIFICATE("RENEWABLE_ENERGY_CERTIFICATE", null),
	
	/**
	 * Australia Green Energy: Australian Carbon Credit Unit.
	 */
	@RosettaEnumValue(value = "AUSCARBON_CREDIT_UNIT") 
	AUSCARBON_CREDIT_UNIT("AUSCARBON_CREDIT_UNIT", null),
	
	/**
	 * Australia Green Energy: Australian Carbon Unit.
	 */
	@RosettaEnumValue(value = "AUSCARBON_UNIT") 
	AUSCARBON_UNIT("AUSCARBON_UNIT", null),
	
	/**
	 * Australia Green Energy: Energy Savings Certificate.
	 */
	@RosettaEnumValue(value = "AUSENERGY_SAVING_CERTIFICATE") 
	AUSENERGY_SAVING_CERTIFICATE("AUSENERGY_SAVING_CERTIFICATE", null),
	
	/**
	 * Australia Green Energy: Large-scale Generation Certificate.
	 */
	@RosettaEnumValue(value = "AUSLARGE_SCALE_GENERATION_CERTIFICATE") 
	AUSLARGE_SCALE_GENERATION_CERTIFICATE("AUSLARGE_SCALE_GENERATION_CERTIFICATE", null),
	
	/**
	 * Australia Green Energy: Small-scale Technology Certificate.
	 */
	@RosettaEnumValue(value = "AUSSMALL_SCALE_TECHNOLOGY_CERTIFICATE") 
	AUSSMALL_SCALE_TECHNOLOGY_CERTIFICATE("AUSSMALL_SCALE_TECHNOLOGY_CERTIFICATE", null),
	
	/**
	 * Australia Green Energy: Victorian Energy Efficiency Certificate.
	 */
	@RosettaEnumValue(value = "AUSVICTORIAN_ENERGY_EFFICIENCY_CERTIFICATE") 
	AUSVICTORIAN_ENERGY_EFFICIENCY_CERTIFICATE("AUSVICTORIAN_ENERGY_EFFICIENCY_CERTIFICATE", null),
	
	/**
	 * Mexico CCFE CRT INTLODS Physical Certificates.
	 */
	@RosettaEnumValue(value = "MXCCFECRTINTLODS") 
	MXCCFECRTINTLODS("MXCCFECRTINTLODS", null),
	
	/**
	 * New Zealand Emissions Units.
	 */
	@RosettaEnumValue(value = "NZEMISSIONS_UNITS") 
	NZEMISSIONS_UNITS("NZEMISSIONS_UNITS", null),
	
	/**
	 * United Kingdom Ofgem Renewable Obligation Certificate.
	 */
	@RosettaEnumValue(value = "UKRENEWABLE_OBLIGATION_CERTIFICATE") 
	UKRENEWABLE_OBLIGATION_CERTIFICATE("UKRENEWABLE_OBLIGATION_CERTIFICATE", null)
;
	private static Map<String, EnvironmentalProductTypeEnum> values;
	static {
        Map<String, EnvironmentalProductTypeEnum> map = new ConcurrentHashMap<>();
		for (EnvironmentalProductTypeEnum instance : EnvironmentalProductTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EnvironmentalProductTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EnvironmentalProductTypeEnum fromDisplayName(String name) {
		EnvironmentalProductTypeEnum value = values.get(name);
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
