package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationSettlementEvent;
import fpml.confirmation.validation.LoanAllocationSettlementEventTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationSettlementEventValidator;
import fpml.confirmation.validation.exists.LoanAllocationSettlementEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationSettlementEvent.class)
public class LoanAllocationSettlementEventMeta implements RosettaMetaData<LoanAllocationSettlementEvent> {

	@Override
	public List<Validator<? super LoanAllocationSettlementEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationSettlementEvent> validator() {
		return new LoanAllocationSettlementEventValidator();
	}

	@Override
	public Validator<? super LoanAllocationSettlementEvent> typeFormatValidator() {
		return new LoanAllocationSettlementEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementEvent, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementEventOnlyExistsValidator();
	}
}
