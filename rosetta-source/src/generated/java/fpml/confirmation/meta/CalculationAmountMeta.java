package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationAmount;
import fpml.confirmation.validation.CalculationAmountTypeFormatValidator;
import fpml.confirmation.validation.CalculationAmountValidator;
import fpml.confirmation.validation.exists.CalculationAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationAmount.class)
public class CalculationAmountMeta implements RosettaMetaData<CalculationAmount> {

	@Override
	public List<Validator<? super CalculationAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationAmount> validator() {
		return new CalculationAmountValidator();
	}

	@Override
	public Validator<? super CalculationAmount> typeFormatValidator() {
		return new CalculationAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAmount, Set<String>> onlyExistsValidator() {
		return new CalculationAmountOnlyExistsValidator();
	}
}
