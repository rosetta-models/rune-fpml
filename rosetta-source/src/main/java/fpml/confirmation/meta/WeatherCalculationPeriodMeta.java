package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherCalculationPeriod;
import fpml.confirmation.validation.WeatherCalculationPeriodTypeFormatValidator;
import fpml.confirmation.validation.WeatherCalculationPeriodValidator;
import fpml.confirmation.validation.exists.WeatherCalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeatherCalculationPeriod.class)
public class WeatherCalculationPeriodMeta implements RosettaMetaData<WeatherCalculationPeriod> {

	@Override
	public List<Validator<? super WeatherCalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherCalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherCalculationPeriod> validator() {
		return new WeatherCalculationPeriodValidator();
	}

	@Override
	public Validator<? super WeatherCalculationPeriod> typeFormatValidator() {
		return new WeatherCalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherCalculationPeriod, Set<String>> onlyExistsValidator() {
		return new WeatherCalculationPeriodOnlyExistsValidator();
	}
}
