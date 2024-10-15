package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransferFeeSequence;
import fpml.confirmation.validation.LoanTransferFeeSequenceTypeFormatValidator;
import fpml.confirmation.validation.LoanTransferFeeSequenceValidator;
import fpml.confirmation.validation.exists.LoanTransferFeeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTransferFeeSequence.class)
public class LoanTransferFeeSequenceMeta implements RosettaMetaData<LoanTransferFeeSequence> {

	@Override
	public List<Validator<? super LoanTransferFeeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTransferFeeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTransferFeeSequence> validator() {
		return new LoanTransferFeeSequenceValidator();
	}

	@Override
	public Validator<? super LoanTransferFeeSequence> typeFormatValidator() {
		return new LoanTransferFeeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransferFeeSequence, Set<String>> onlyExistsValidator() {
		return new LoanTransferFeeSequenceOnlyExistsValidator();
	}
}
