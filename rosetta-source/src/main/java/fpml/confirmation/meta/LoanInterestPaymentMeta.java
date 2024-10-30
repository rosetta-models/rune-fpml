package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.validation.LoanInterestPaymentTypeFormatValidator;
import fpml.confirmation.validation.LoanInterestPaymentValidator;
import fpml.confirmation.validation.exists.LoanInterestPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanInterestPayment.class)
public class LoanInterestPaymentMeta implements RosettaMetaData<LoanInterestPayment> {

	@Override
	public List<Validator<? super LoanInterestPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanInterestPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanInterestPayment> validator() {
		return new LoanInterestPaymentValidator();
	}

	@Override
	public Validator<? super LoanInterestPayment> typeFormatValidator() {
		return new LoanInterestPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanInterestPayment, Set<String>> onlyExistsValidator() {
		return new LoanInterestPaymentOnlyExistsValidator();
	}
}
