package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherStation;
import fpml.confirmation.validation.WeatherStationTypeFormatValidator;
import fpml.confirmation.validation.WeatherStationValidator;
import fpml.confirmation.validation.exists.WeatherStationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WeatherStation.class)
public class WeatherStationMeta implements RosettaMetaData<WeatherStation> {

	@Override
	public List<Validator<? super WeatherStation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.WeatherStation>create(fpml.confirmation.validation.datarule.WeatherStationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WeatherStation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherStation> validator() {
		return new WeatherStationValidator();
	}

	@Override
	public Validator<? super WeatherStation> typeFormatValidator() {
		return new WeatherStationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStation, Set<String>> onlyExistsValidator() {
		return new WeatherStationOnlyExistsValidator();
	}
}
