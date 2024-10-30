package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.validation.WeatherCalculationPeriodModelTypeFormatValidator;
import fpml.confirmation.validation.WeatherCalculationPeriodModelValidator;
import fpml.confirmation.validation.exists.WeatherCalculationPeriodModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeatherCalculationPeriodModel.class)
public class WeatherCalculationPeriodModelMeta implements RosettaMetaData<WeatherCalculationPeriodModel> {

	@Override
	public List<Validator<? super WeatherCalculationPeriodModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.WeatherCalculationPeriodModel>create(fpml.confirmation.validation.datarule.WeatherCalculationPeriodModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WeatherCalculationPeriodModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeatherCalculationPeriodModel> validator() {
		return new WeatherCalculationPeriodModelValidator();
	}

	@Override
	public Validator<? super WeatherCalculationPeriodModel> typeFormatValidator() {
		return new WeatherCalculationPeriodModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherCalculationPeriodModel, Set<String>> onlyExistsValidator() {
		return new WeatherCalculationPeriodModelOnlyExistsValidator();
	}
}
