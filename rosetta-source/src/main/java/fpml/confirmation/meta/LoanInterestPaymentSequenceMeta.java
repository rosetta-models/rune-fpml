package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanInterestPaymentSequence;
import fpml.confirmation.validation.LoanInterestPaymentSequenceTypeFormatValidator;
import fpml.confirmation.validation.LoanInterestPaymentSequenceValidator;
import fpml.confirmation.validation.exists.LoanInterestPaymentSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanInterestPaymentSequence.class)
public class LoanInterestPaymentSequenceMeta implements RosettaMetaData<LoanInterestPaymentSequence> {

	@Override
	public List<Validator<? super LoanInterestPaymentSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanInterestPaymentSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanInterestPaymentSequence> validator() {
		return new LoanInterestPaymentSequenceValidator();
	}

	@Override
	public Validator<? super LoanInterestPaymentSequence> typeFormatValidator() {
		return new LoanInterestPaymentSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanInterestPaymentSequence, Set<String>> onlyExistsValidator() {
		return new LoanInterestPaymentSequenceOnlyExistsValidator();
	}
}
