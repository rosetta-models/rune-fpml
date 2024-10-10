package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationPaymentSequence;
import fpml.confirmation.validation.LoanAllocationPaymentSequenceTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationPaymentSequenceValidator;
import fpml.confirmation.validation.exists.LoanAllocationPaymentSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationPaymentSequence.class)
public class LoanAllocationPaymentSequenceMeta implements RosettaMetaData<LoanAllocationPaymentSequence> {

	@Override
	public List<Validator<? super LoanAllocationPaymentSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationPaymentSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationPaymentSequence> validator() {
		return new LoanAllocationPaymentSequenceValidator();
	}

	@Override
	public Validator<? super LoanAllocationPaymentSequence> typeFormatValidator() {
		return new LoanAllocationPaymentSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationPaymentSequence, Set<String>> onlyExistsValidator() {
		return new LoanAllocationPaymentSequenceOnlyExistsValidator();
	}
}
