package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.RollConventionEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaEnum("RollConventionEnum")
public enum RollConventionEnum {

	@RosettaEnumValue(value = "EOM") 
	EOM("EOM", null),
	
	@RosettaEnumValue(value = "FRN") 
	FRN("FRN", null),
	
	@RosettaEnumValue(value = "IMM") 
	IMM("IMM", null),
	
	@RosettaEnumValue(value = "IMMCAD") 
	IMMCAD("IMMCAD", null),
	
	@RosettaEnumValue(value = "IMMAUD") 
	IMMAUD("IMMAUD", null),
	
	@RosettaEnumValue(value = "IMMNZD") 
	IMMNZD("IMMNZD", null),
	
	@RosettaEnumValue(value = "SFE") 
	SFE("SFE", null),
	
	@RosettaEnumValue(value = "NONE") 
	NONE("NONE", null),
	
	@RosettaEnumValue(value = "TBILL") 
	TBILL("TBILL", null),
	
	@RosettaEnumValue(value = "_1") 
	_1("_1", null),
	
	@RosettaEnumValue(value = "_2") 
	_2("_2", null),
	
	@RosettaEnumValue(value = "_3") 
	_3("_3", null),
	
	@RosettaEnumValue(value = "_4") 
	_4("_4", null),
	
	@RosettaEnumValue(value = "_5") 
	_5("_5", null),
	
	@RosettaEnumValue(value = "_6") 
	_6("_6", null),
	
	@RosettaEnumValue(value = "_7") 
	_7("_7", null),
	
	@RosettaEnumValue(value = "_8") 
	_8("_8", null),
	
	@RosettaEnumValue(value = "_9") 
	_9("_9", null),
	
	@RosettaEnumValue(value = "_10") 
	_10("_10", null),
	
	@RosettaEnumValue(value = "_11") 
	_11("_11", null),
	
	@RosettaEnumValue(value = "_12") 
	_12("_12", null),
	
	@RosettaEnumValue(value = "_13") 
	_13("_13", null),
	
	@RosettaEnumValue(value = "_14") 
	_14("_14", null),
	
	@RosettaEnumValue(value = "_15") 
	_15("_15", null),
	
	@RosettaEnumValue(value = "_16") 
	_16("_16", null),
	
	@RosettaEnumValue(value = "_17") 
	_17("_17", null),
	
	@RosettaEnumValue(value = "_18") 
	_18("_18", null),
	
	@RosettaEnumValue(value = "_19") 
	_19("_19", null),
	
	@RosettaEnumValue(value = "_20") 
	_20("_20", null),
	
	@RosettaEnumValue(value = "_21") 
	_21("_21", null),
	
	@RosettaEnumValue(value = "_22") 
	_22("_22", null),
	
	@RosettaEnumValue(value = "_23") 
	_23("_23", null),
	
	@RosettaEnumValue(value = "_24") 
	_24("_24", null),
	
	@RosettaEnumValue(value = "_25") 
	_25("_25", null),
	
	@RosettaEnumValue(value = "_26") 
	_26("_26", null),
	
	@RosettaEnumValue(value = "_27") 
	_27("_27", null),
	
	@RosettaEnumValue(value = "_28") 
	_28("_28", null),
	
	@RosettaEnumValue(value = "_29") 
	_29("_29", null),
	
	@RosettaEnumValue(value = "_30") 
	_30("_30", null),
	
	@RosettaEnumValue(value = "MON") 
	MON("MON", null),
	
	@RosettaEnumValue(value = "TUE") 
	TUE("TUE", null),
	
	@RosettaEnumValue(value = "WED") 
	WED("WED", null),
	
	@RosettaEnumValue(value = "THU") 
	THU("THU", null),
	
	@RosettaEnumValue(value = "FRI") 
	FRI("FRI", null),
	
	@RosettaEnumValue(value = "SAT") 
	SAT("SAT", null),
	
	@RosettaEnumValue(value = "SUN") 
	SUN("SUN", null)
;
	private static Map<String, RollConventionEnum> values;
	static {
        Map<String, RollConventionEnum> map = new ConcurrentHashMap<>();
		for (RollConventionEnum instance : RollConventionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RollConventionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RollConventionEnum fromDisplayName(String name) {
		RollConventionEnum value = values.get(name);
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
