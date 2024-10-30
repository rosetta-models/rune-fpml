package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherLegCalculation;
import fpml.confirmation.validation.WeatherLegCalculationTypeFormatValidator;
import fpml.confirmation.validation.WeatherLegCalculationValidator;
import fpml.confirmation.validation.exists.WeatherLegCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeatherLegCalculation.class)
public class WeatherLegCalculationMeta implements RosettaMetaData<WeatherLegCalculation> {

	@Override
	public List<Validator<? super WeatherLegCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherLegCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherLegCalculation> validator() {
		return new WeatherLegCalculationValidator();
	}

	@Override
	public Validator<? super WeatherLegCalculation> typeFormatValidator() {
		return new WeatherLegCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherLegCalculation, Set<String>> onlyExistsValidator() {
		return new WeatherLegCalculationOnlyExistsValidator();
	}
}
