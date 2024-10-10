package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherStationAirport;
import fpml.confirmation.validation.WeatherStationAirportTypeFormatValidator;
import fpml.confirmation.validation.WeatherStationAirportValidator;
import fpml.confirmation.validation.exists.WeatherStationAirportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WeatherStationAirport.class)
public class WeatherStationAirportMeta implements RosettaMetaData<WeatherStationAirport> {

	@Override
	public List<Validator<? super WeatherStationAirport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherStationAirport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherStationAirport> validator() {
		return new WeatherStationAirportValidator();
	}

	@Override
	public Validator<? super WeatherStationAirport> typeFormatValidator() {
		return new WeatherStationAirportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStationAirport, Set<String>> onlyExistsValidator() {
		return new WeatherStationAirportOnlyExistsValidator();
	}
}
