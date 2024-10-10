package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent;
import fpml.confirmation.validation.LoanAllocationTransferFeeDueEventTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationTransferFeeDueEventValidator;
import fpml.confirmation.validation.exists.LoanAllocationTransferFeeDueEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationTransferFeeDueEvent.class)
public class LoanAllocationTransferFeeDueEventMeta implements RosettaMetaData<LoanAllocationTransferFeeDueEvent> {

	@Override
	public List<Validator<? super LoanAllocationTransferFeeDueEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationTransferFeeDueEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeDueEvent> validator() {
		return new LoanAllocationTransferFeeDueEventValidator();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeDueEvent> typeFormatValidator() {
		return new LoanAllocationTransferFeeDueEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationTransferFeeDueEvent, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTransferFeeDueEventOnlyExistsValidator();
	}
}
