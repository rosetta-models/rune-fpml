package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedAmountCalculation;
import fpml.confirmation.validation.FixedAmountCalculationTypeFormatValidator;
import fpml.confirmation.validation.FixedAmountCalculationValidator;
import fpml.confirmation.validation.exists.FixedAmountCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedAmountCalculation.class)
public class FixedAmountCalculationMeta implements RosettaMetaData<FixedAmountCalculation> {

	@Override
	public List<Validator<? super FixedAmountCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedAmountCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedAmountCalculation> validator() {
		return new FixedAmountCalculationValidator();
	}

	@Override
	public Validator<? super FixedAmountCalculation> typeFormatValidator() {
		return new FixedAmountCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedAmountCalculation, Set<String>> onlyExistsValidator() {
		return new FixedAmountCalculationOnlyExistsValidator();
	}
}
