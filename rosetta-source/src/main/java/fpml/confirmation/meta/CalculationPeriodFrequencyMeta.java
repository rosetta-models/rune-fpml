package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.validation.CalculationPeriodFrequencyTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodFrequencyValidator;
import fpml.confirmation.validation.exists.CalculationPeriodFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationPeriodFrequency.class)
public class CalculationPeriodFrequencyMeta implements RosettaMetaData<CalculationPeriodFrequency> {

	@Override
	public List<Validator<? super CalculationPeriodFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodFrequency> validator() {
		return new CalculationPeriodFrequencyValidator();
	}

	@Override
	public Validator<? super CalculationPeriodFrequency> typeFormatValidator() {
		return new CalculationPeriodFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodFrequency, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodFrequencyOnlyExistsValidator();
	}
}
