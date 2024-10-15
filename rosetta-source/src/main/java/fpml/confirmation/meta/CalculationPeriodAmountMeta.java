package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodAmount;
import fpml.confirmation.validation.CalculationPeriodAmountTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodAmountValidator;
import fpml.confirmation.validation.exists.CalculationPeriodAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationPeriodAmount.class)
public class CalculationPeriodAmountMeta implements RosettaMetaData<CalculationPeriodAmount> {

	@Override
	public List<Validator<? super CalculationPeriodAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationPeriodAmount>create(fpml.confirmation.validation.datarule.CalculationPeriodAmountChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodAmount> validator() {
		return new CalculationPeriodAmountValidator();
	}

	@Override
	public Validator<? super CalculationPeriodAmount> typeFormatValidator() {
		return new CalculationPeriodAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodAmount, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodAmountOnlyExistsValidator();
	}
}
