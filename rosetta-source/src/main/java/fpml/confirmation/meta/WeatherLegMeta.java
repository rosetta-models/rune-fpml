package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherLeg;
import fpml.confirmation.validation.WeatherLegTypeFormatValidator;
import fpml.confirmation.validation.WeatherLegValidator;
import fpml.confirmation.validation.exists.WeatherLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeatherLeg.class)
public class WeatherLegMeta implements RosettaMetaData<WeatherLeg> {

	@Override
	public List<Validator<? super WeatherLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherLeg> validator() {
		return new WeatherLegValidator();
	}

	@Override
	public Validator<? super WeatherLeg> typeFormatValidator() {
		return new WeatherLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherLeg, Set<String>> onlyExistsValidator() {
		return new WeatherLegOnlyExistsValidator();
	}
}
