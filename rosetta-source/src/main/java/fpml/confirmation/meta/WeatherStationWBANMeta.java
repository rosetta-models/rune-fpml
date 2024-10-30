package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherStationWBAN;
import fpml.confirmation.validation.WeatherStationWBANTypeFormatValidator;
import fpml.confirmation.validation.WeatherStationWBANValidator;
import fpml.confirmation.validation.exists.WeatherStationWBANOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeatherStationWBAN.class)
public class WeatherStationWBANMeta implements RosettaMetaData<WeatherStationWBAN> {

	@Override
	public List<Validator<? super WeatherStationWBAN>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherStationWBAN, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherStationWBAN> validator() {
		return new WeatherStationWBANValidator();
	}

	@Override
	public Validator<? super WeatherStationWBAN> typeFormatValidator() {
		return new WeatherStationWBANTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStationWBAN, Set<String>> onlyExistsValidator() {
		return new WeatherStationWBANOnlyExistsValidator();
	}
}
