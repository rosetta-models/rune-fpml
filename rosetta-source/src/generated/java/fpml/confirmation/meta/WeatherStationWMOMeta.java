package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherStationWMO;
import fpml.confirmation.validation.WeatherStationWMOTypeFormatValidator;
import fpml.confirmation.validation.WeatherStationWMOValidator;
import fpml.confirmation.validation.exists.WeatherStationWMOOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WeatherStationWMO.class)
public class WeatherStationWMOMeta implements RosettaMetaData<WeatherStationWMO> {

	@Override
	public List<Validator<? super WeatherStationWMO>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherStationWMO, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherStationWMO> validator() {
		return new WeatherStationWMOValidator();
	}

	@Override
	public Validator<? super WeatherStationWMO> typeFormatValidator() {
		return new WeatherStationWMOTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStationWMO, Set<String>> onlyExistsValidator() {
		return new WeatherStationWMOOnlyExistsValidator();
	}
}
