package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculatedAmount;
import fpml.confirmation.validation.CalculatedAmountTypeFormatValidator;
import fpml.confirmation.validation.CalculatedAmountValidator;
import fpml.confirmation.validation.exists.CalculatedAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculatedAmount.class)
public class CalculatedAmountMeta implements RosettaMetaData<CalculatedAmount> {

	@Override
	public List<Validator<? super CalculatedAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculatedAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculatedAmount> validator() {
		return new CalculatedAmountValidator();
	}

	@Override
	public Validator<? super CalculatedAmount> typeFormatValidator() {
		return new CalculatedAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculatedAmount, Set<String>> onlyExistsValidator() {
		return new CalculatedAmountOnlyExistsValidator();
	}
}
