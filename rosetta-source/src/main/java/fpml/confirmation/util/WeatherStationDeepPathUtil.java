package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.WeatherStation;
import fpml.confirmation.WeatherStationAirport;
import fpml.confirmation.WeatherStationWBAN;
import fpml.confirmation.WeatherStationWMO;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class WeatherStationDeepPathUtil {
	public String chooseId(WeatherStation weatherStation) {
		final MapperS<BusinessCenter> weatherStationCity = MapperS.of(weatherStation).<BusinessCenter>map("getWeatherStationCity", _weatherStation -> _weatherStation.getWeatherStationCity());
		if (exists(weatherStationCity).getOrDefault(false)) {
			return weatherStationCity.<String>map("getId", businessCenter -> businessCenter.getId()).get();
		}
		final MapperS<WeatherStationAirport> weatherStationAirport = MapperS.of(weatherStation).<WeatherStationAirport>map("getWeatherStationAirport", _weatherStation -> _weatherStation.getWeatherStationAirport());
		if (exists(weatherStationAirport).getOrDefault(false)) {
			return weatherStationAirport.<String>map("getId", _weatherStationAirport -> _weatherStationAirport.getId()).get();
		}
		final MapperS<WeatherStationWBAN> weatherStationWBAN = MapperS.of(weatherStation).<WeatherStationWBAN>map("getWeatherStationWBAN", _weatherStation -> _weatherStation.getWeatherStationWBAN());
		if (exists(weatherStationWBAN).getOrDefault(false)) {
			return weatherStationWBAN.<String>map("getId", _weatherStationWBAN -> _weatherStationWBAN.getId()).get();
		}
		final MapperS<WeatherStationWMO> weatherStationWMO = MapperS.of(weatherStation).<WeatherStationWMO>map("getWeatherStationWMO", _weatherStation -> _weatherStation.getWeatherStationWMO());
		if (exists(weatherStationWMO).getOrDefault(false)) {
			return weatherStationWMO.<String>map("getId", _weatherStationWMO -> _weatherStationWMO.getId()).get();
		}
		return null;
	}
	
	public String chooseValue(WeatherStation weatherStation) {
		final MapperS<BusinessCenter> weatherStationCity = MapperS.of(weatherStation).<BusinessCenter>map("getWeatherStationCity", _weatherStation -> _weatherStation.getWeatherStationCity());
		if (exists(weatherStationCity).getOrDefault(false)) {
			return weatherStationCity.<String>map("getValue", businessCenter -> businessCenter.getValue()).get();
		}
		final MapperS<WeatherStationAirport> weatherStationAirport = MapperS.of(weatherStation).<WeatherStationAirport>map("getWeatherStationAirport", _weatherStation -> _weatherStation.getWeatherStationAirport());
		if (exists(weatherStationAirport).getOrDefault(false)) {
			return weatherStationAirport.<String>map("getValue", _weatherStationAirport -> _weatherStationAirport.getValue()).get();
		}
		final MapperS<WeatherStationWBAN> weatherStationWBAN = MapperS.of(weatherStation).<WeatherStationWBAN>map("getWeatherStationWBAN", _weatherStation -> _weatherStation.getWeatherStationWBAN());
		if (exists(weatherStationWBAN).getOrDefault(false)) {
			return weatherStationWBAN.<String>map("getValue", _weatherStationWBAN -> _weatherStationWBAN.getValue()).get();
		}
		final MapperS<WeatherStationWMO> weatherStationWMO = MapperS.of(weatherStation).<WeatherStationWMO>map("getWeatherStationWMO", _weatherStation -> _weatherStation.getWeatherStationWMO());
		if (exists(weatherStationWMO).getOrDefault(false)) {
			return weatherStationWMO.<String>map("getValue", _weatherStationWMO -> _weatherStationWMO.getValue()).get();
		}
		return null;
	}
	
}
