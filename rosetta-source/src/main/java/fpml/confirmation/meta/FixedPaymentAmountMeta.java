package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedPaymentAmount;
import fpml.confirmation.validation.FixedPaymentAmountTypeFormatValidator;
import fpml.confirmation.validation.FixedPaymentAmountValidator;
import fpml.confirmation.validation.exists.FixedPaymentAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedPaymentAmount.class)
public class FixedPaymentAmountMeta implements RosettaMetaData<FixedPaymentAmount> {

	@Override
	public List<Validator<? super FixedPaymentAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedPaymentAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedPaymentAmount> validator() {
		return new FixedPaymentAmountValidator();
	}

	@Override
	public Validator<? super FixedPaymentAmount> typeFormatValidator() {
		return new FixedPaymentAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPaymentAmount, Set<String>> onlyExistsValidator() {
		return new FixedPaymentAmountOnlyExistsValidator();
	}
}
