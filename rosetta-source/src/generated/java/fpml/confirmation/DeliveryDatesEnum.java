package fpml.confirmation;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import fpml.confirmation.DeliveryDatesEnum;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DeliveryDatesEnum")
public enum DeliveryDatesEnum {

	@RosettaEnumValue(value = "CALCULATION_PERIOD") 
	CALCULATION_PERIOD("CALCULATION_PERIOD", null),
	
	@RosettaEnumValue(value = "FIRST_NEARBY") 
	FIRST_NEARBY("FIRST_NEARBY", null),
	
	@RosettaEnumValue(value = "SECOND_NEARBY") 
	SECOND_NEARBY("SECOND_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRD_NEARBY") 
	THIRD_NEARBY("THIRD_NEARBY", null),
	
	@RosettaEnumValue(value = "FOURTH_NEARBY") 
	FOURTH_NEARBY("FOURTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTH_NEARBY") 
	FIFTH_NEARBY("FIFTH_NEARBY", null),
	
	@RosettaEnumValue(value = "SIXTH_NEARBY") 
	SIXTH_NEARBY("SIXTH_NEARBY", null),
	
	@RosettaEnumValue(value = "SEVENTH_NEARBY") 
	SEVENTH_NEARBY("SEVENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "EIGHTH_NEARBY") 
	EIGHTH_NEARBY("EIGHTH_NEARBY", null),
	
	@RosettaEnumValue(value = "NINTH_NEARBY") 
	NINTH_NEARBY("NINTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TENTH_NEARBY") 
	TENTH_NEARBY("TENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "ELEVENTH_NEARBY") 
	ELEVENTH_NEARBY("ELEVENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWELFTH_NEARBY") 
	TWELFTH_NEARBY("TWELFTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTEENTH_NEARBY") 
	THIRTEENTH_NEARBY("THIRTEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FOURTEENTH_NEARBY") 
	FOURTEENTH_NEARBY("FOURTEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTEENTH_NEARBY") 
	FIFTEENTH_NEARBY("FIFTEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "SIXTEENTH_NEARBY") 
	SIXTEENTH_NEARBY("SIXTEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "SEVENTEENTH_NEARBY") 
	SEVENTEENTH_NEARBY("SEVENTEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "EIGHTEENTH_NEARBY") 
	EIGHTEENTH_NEARBY("EIGHTEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "NINETEENTH_NEARBY") 
	NINETEENTH_NEARBY("NINETEENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTIETH_NEARBY") 
	TWENTIETH_NEARBY("TWENTIETH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_FIRST_NEARBY") 
	TWENTY_FIRST_NEARBY("TWENTY_FIRST_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_SECOND_NEARBY") 
	TWENTY_SECOND_NEARBY("TWENTY_SECOND_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_THIRD_NEARBY") 
	TWENTY_THIRD_NEARBY("TWENTY_THIRD_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_FOURTH_NEARBY") 
	TWENTY_FOURTH_NEARBY("TWENTY_FOURTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_FIFTH_NEARBY") 
	TWENTY_FIFTH_NEARBY("TWENTY_FIFTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_SIXTH_NEARBY") 
	TWENTY_SIXTH_NEARBY("TWENTY_SIXTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_SEVENTH_NEARBY") 
	TWENTY_SEVENTH_NEARBY("TWENTY_SEVENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_EIGHTH_NEARBY") 
	TWENTY_EIGHTH_NEARBY("TWENTY_EIGHTH_NEARBY", null),
	
	@RosettaEnumValue(value = "TWENTY_NINTH_NEARBY") 
	TWENTY_NINTH_NEARBY("TWENTY_NINTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTIETH_NEARBY") 
	THIRTIETH_NEARBY("THIRTIETH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_FIRST_NEARBY") 
	THIRTY_FIRST_NEARBY("THIRTY_FIRST_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_SECOND_NEARBY") 
	THIRTY_SECOND_NEARBY("THIRTY_SECOND_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_THIRD_NEARBY") 
	THIRTY_THIRD_NEARBY("THIRTY_THIRD_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_FOURTH_NEARBY") 
	THIRTY_FOURTH_NEARBY("THIRTY_FOURTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_FIFTH_NEARBY") 
	THIRTY_FIFTH_NEARBY("THIRTY_FIFTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_SIXTH_NEARBY") 
	THIRTY_SIXTH_NEARBY("THIRTY_SIXTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_SEVENTH_NEARBY") 
	THIRTY_SEVENTH_NEARBY("THIRTY_SEVENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_EIGHTH_NEARBY") 
	THIRTY_EIGHTH_NEARBY("THIRTY_EIGHTH_NEARBY", null),
	
	@RosettaEnumValue(value = "THIRTY_NINTH_NEARBY") 
	THIRTY_NINTH_NEARBY("THIRTY_NINTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTIETH_NEARBY") 
	FORTIETH_NEARBY("FORTIETH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_FIRST_NEARBY") 
	FORTY_FIRST_NEARBY("FORTY_FIRST_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_SECOND_NEARBY") 
	FORTY_SECOND_NEARBY("FORTY_SECOND_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_THIRD_NEARBY") 
	FORTY_THIRD_NEARBY("FORTY_THIRD_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_FOURTH_NEARBY") 
	FORTY_FOURTH_NEARBY("FORTY_FOURTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_FIFTH_NEARBY") 
	FORTY_FIFTH_NEARBY("FORTY_FIFTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_SIXTH_NEARBY") 
	FORTY_SIXTH_NEARBY("FORTY_SIXTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_SEVENTH_NEARBY") 
	FORTY_SEVENTH_NEARBY("FORTY_SEVENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_EIGHTH_NEARBY") 
	FORTY_EIGHTH_NEARBY("FORTY_EIGHTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FORTY_NINTH_NEARBY") 
	FORTY_NINTH_NEARBY("FORTY_NINTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTIETH_NEARBY") 
	FIFTIETH_NEARBY("FIFTIETH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_FIRST_NEARBY") 
	FIFTY_FIRST_NEARBY("FIFTY_FIRST_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_SECOND_NEARBY") 
	FIFTY_SECOND_NEARBY("FIFTY_SECOND_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_THIRD_NEARBY") 
	FIFTY_THIRD_NEARBY("FIFTY_THIRD_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_FOURTH_NEARBY") 
	FIFTY_FOURTH_NEARBY("FIFTY_FOURTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_FIFTH_NEARBY") 
	FIFTY_FIFTH_NEARBY("FIFTY_FIFTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_SIXTH_NEARBY") 
	FIFTY_SIXTH_NEARBY("FIFTY_SIXTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_SEVENTH_NEARBY") 
	FIFTY_SEVENTH_NEARBY("FIFTY_SEVENTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_EIGHTH_NEARBY") 
	FIFTY_EIGHTH_NEARBY("FIFTY_EIGHTH_NEARBY", null),
	
	@RosettaEnumValue(value = "FIFTY_NINTH_NEARBY") 
	FIFTY_NINTH_NEARBY("FIFTY_NINTH_NEARBY", null),
	
	@RosettaEnumValue(value = "SPOT") 
	SPOT("SPOT", null),
	
	@RosettaEnumValue(value = "FIRST_NEARBY_WEEK") 
	FIRST_NEARBY_WEEK("FIRST_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "SECOND_NEARBY_WEEK") 
	SECOND_NEARBY_WEEK("SECOND_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRD_NEARBY_WEEK") 
	THIRD_NEARBY_WEEK("THIRD_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FOURTH_NEARBY_WEEK") 
	FOURTH_NEARBY_WEEK("FOURTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FIFTH_NEARBY_WEEK") 
	FIFTH_NEARBY_WEEK("FIFTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "SIXTH_NEARBY_WEEK") 
	SIXTH_NEARBY_WEEK("SIXTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "SEVENTH_NEARBY_WEEK") 
	SEVENTH_NEARBY_WEEK("SEVENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "EIGHTH_NEARBY_WEEK") 
	EIGHTH_NEARBY_WEEK("EIGHTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "NINTH_NEARBY_WEEK") 
	NINTH_NEARBY_WEEK("NINTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TENTH_NEARBY_WEEK") 
	TENTH_NEARBY_WEEK("TENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "ELEVENTH_NEARBY_WEEK") 
	ELEVENTH_NEARBY_WEEK("ELEVENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWELFTH_NEARBY_WEEK") 
	TWELFTH_NEARBY_WEEK("TWELFTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTEENTH_NEARBY_WEEK") 
	THIRTEENTH_NEARBY_WEEK("THIRTEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FOURTEENTH_NEARBY_WEEK") 
	FOURTEENTH_NEARBY_WEEK("FOURTEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FIFTEENTH_NEARBY_WEEK") 
	FIFTEENTH_NEARBY_WEEK("FIFTEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "SIXTEENTH_NEARBY_WEEK") 
	SIXTEENTH_NEARBY_WEEK("SIXTEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "SEVENTEENTH_NEARBY_WEEK") 
	SEVENTEENTH_NEARBY_WEEK("SEVENTEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "EIGHTEENTH_NEARBY_WEEK") 
	EIGHTEENTH_NEARBY_WEEK("EIGHTEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "NINETEENTH_NEARBY_WEEK") 
	NINETEENTH_NEARBY_WEEK("NINETEENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTIETH_NEARBY_WEEK") 
	TWENTIETH_NEARBY_WEEK("TWENTIETH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_FIRST_NEARBY_WEEK") 
	TWENTY_FIRST_NEARBY_WEEK("TWENTY_FIRST_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_SECOND_NEARBY_WEEK") 
	TWENTY_SECOND_NEARBY_WEEK("TWENTY_SECOND_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_THIRD_NEARBY_WEEK") 
	TWENTY_THIRD_NEARBY_WEEK("TWENTY_THIRD_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_FOURTHEARBY_WEEK") 
	TWENTY_FOURTHEARBY_WEEK("TWENTY_FOURTHEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_FIFTH_NEARBY_WEEK") 
	TWENTY_FIFTH_NEARBY_WEEK("TWENTY_FIFTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_SIXTH_NEARBY_WEEK") 
	TWENTY_SIXTH_NEARBY_WEEK("TWENTY_SIXTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_SEVENTH_NEARBY_WEEK") 
	TWENTY_SEVENTH_NEARBY_WEEK("TWENTY_SEVENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_EIGHTH_NEARBY_WEEK") 
	TWENTY_EIGHTH_NEARBY_WEEK("TWENTY_EIGHTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "TWENTY_NINTH_NEARBY_WEEK") 
	TWENTY_NINTH_NEARBY_WEEK("TWENTY_NINTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTIETH_NEARBY_WEEK") 
	THIRTIETH_NEARBY_WEEK("THIRTIETH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_FIRST_NEARBY_WEEK") 
	THIRTY_FIRST_NEARBY_WEEK("THIRTY_FIRST_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_SECOND_NEARBY_WEEK") 
	THIRTY_SECOND_NEARBY_WEEK("THIRTY_SECOND_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_THIRD_NEARBY_WEEK") 
	THIRTY_THIRD_NEARBY_WEEK("THIRTY_THIRD_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_FOURTH_NEARBY_WEEK") 
	THIRTY_FOURTH_NEARBY_WEEK("THIRTY_FOURTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_FIFTH_NEARBY_WEEK") 
	THIRTY_FIFTH_NEARBY_WEEK("THIRTY_FIFTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_SIXTH_NEARBY_WEEK") 
	THIRTY_SIXTH_NEARBY_WEEK("THIRTY_SIXTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_SEVENTH_NEARBY_WEEK") 
	THIRTY_SEVENTH_NEARBY_WEEK("THIRTY_SEVENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_EIGHTH_NEARBY_WEEK") 
	THIRTY_EIGHTH_NEARBY_WEEK("THIRTY_EIGHTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "THIRTY_NINTH_NEARBY_WEEK") 
	THIRTY_NINTH_NEARBY_WEEK("THIRTY_NINTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTIETH_NEARBY_WEEK") 
	FORTIETH_NEARBY_WEEK("FORTIETH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_FIRST_NEARBY_WEEK") 
	FORTY_FIRST_NEARBY_WEEK("FORTY_FIRST_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_SECOND_NEARBY_WEEK") 
	FORTY_SECOND_NEARBY_WEEK("FORTY_SECOND_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_THIRD_NEARBY_WEEK") 
	FORTY_THIRD_NEARBY_WEEK("FORTY_THIRD_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_FOURTH_NEARBY_WEEK") 
	FORTY_FOURTH_NEARBY_WEEK("FORTY_FOURTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_FIFTH_NEARBY_WEEK") 
	FORTY_FIFTH_NEARBY_WEEK("FORTY_FIFTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_SIXTH_NEARBY_WEEK") 
	FORTY_SIXTH_NEARBY_WEEK("FORTY_SIXTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_SEVENTH_NEARBY_WEEK") 
	FORTY_SEVENTH_NEARBY_WEEK("FORTY_SEVENTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_EIGHTH_NEARBY_WEEK") 
	FORTY_EIGHTH_NEARBY_WEEK("FORTY_EIGHTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FORTY_NINTH_NEARBY_WEEK") 
	FORTY_NINTH_NEARBY_WEEK("FORTY_NINTH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FIFTIETH_NEARBY_WEEK") 
	FIFTIETH_NEARBY_WEEK("FIFTIETH_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FIFTY_FIRST_NEARBY_WEEK") 
	FIFTY_FIRST_NEARBY_WEEK("FIFTY_FIRST_NEARBY_WEEK", null),
	
	@RosettaEnumValue(value = "FIFTY_SECOND_NEARBY_WEEK") 
	FIFTY_SECOND_NEARBY_WEEK("FIFTY_SECOND_NEARBY_WEEK", null)
;
	private static Map<String, DeliveryDatesEnum> values;
	static {
        Map<String, DeliveryDatesEnum> map = new ConcurrentHashMap<>();
		for (DeliveryDatesEnum instance : DeliveryDatesEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DeliveryDatesEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DeliveryDatesEnum fromDisplayName(String name) {
		DeliveryDatesEnum value = values.get(name);
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
