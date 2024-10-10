package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence;
import fpml.confirmation.validation.LoanSettlementDateAvailabilityEventSequenceTypeFormatValidator;
import fpml.confirmation.validation.LoanSettlementDateAvailabilityEventSequenceValidator;
import fpml.confirmation.validation.exists.LoanSettlementDateAvailabilityEventSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanSettlementDateAvailabilityEventSequence.class)
public class LoanSettlementDateAvailabilityEventSequenceMeta implements RosettaMetaData<LoanSettlementDateAvailabilityEventSequence> {

	@Override
	public List<Validator<? super LoanSettlementDateAvailabilityEventSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanSettlementDateAvailabilityEventSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanSettlementDateAvailabilityEventSequence> validator() {
		return new LoanSettlementDateAvailabilityEventSequenceValidator();
	}

	@Override
	public Validator<? super LoanSettlementDateAvailabilityEventSequence> typeFormatValidator() {
		return new LoanSettlementDateAvailabilityEventSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanSettlementDateAvailabilityEventSequence, Set<String>> onlyExistsValidator() {
		return new LoanSettlementDateAvailabilityEventSequenceOnlyExistsValidator();
	}
}
