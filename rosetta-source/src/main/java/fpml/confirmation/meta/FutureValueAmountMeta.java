package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FutureValueAmount;
import fpml.confirmation.validation.FutureValueAmountTypeFormatValidator;
import fpml.confirmation.validation.FutureValueAmountValidator;
import fpml.confirmation.validation.exists.FutureValueAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FutureValueAmount.class)
public class FutureValueAmountMeta implements RosettaMetaData<FutureValueAmount> {

	@Override
	public List<Validator<? super FutureValueAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FutureValueAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FutureValueAmount> validator() {
		return new FutureValueAmountValidator();
	}

	@Override
	public Validator<? super FutureValueAmount> typeFormatValidator() {
		return new FutureValueAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FutureValueAmount, Set<String>> onlyExistsValidator() {
		return new FutureValueAmountOnlyExistsValidator();
	}
}
