package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent;
import fpml.confirmation.validation.LoanAllocationTransferFeeOwedEventTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationTransferFeeOwedEventValidator;
import fpml.confirmation.validation.exists.LoanAllocationTransferFeeOwedEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationTransferFeeOwedEvent.class)
public class LoanAllocationTransferFeeOwedEventMeta implements RosettaMetaData<LoanAllocationTransferFeeOwedEvent> {

	@Override
	public List<Validator<? super LoanAllocationTransferFeeOwedEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationTransferFeeOwedEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeOwedEvent> validator() {
		return new LoanAllocationTransferFeeOwedEventValidator();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeOwedEvent> typeFormatValidator() {
		return new LoanAllocationTransferFeeOwedEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationTransferFeeOwedEvent, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTransferFeeOwedEventOnlyExistsValidator();
	}
}
