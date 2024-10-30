package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent;
import fpml.confirmation.validation.AbstractLoanAllocationSettlementEventTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanAllocationSettlementEventValidator;
import fpml.confirmation.validation.exists.AbstractLoanAllocationSettlementEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLoanAllocationSettlementEvent.class)
public class AbstractLoanAllocationSettlementEventMeta implements RosettaMetaData<AbstractLoanAllocationSettlementEvent> {

	@Override
	public List<Validator<? super AbstractLoanAllocationSettlementEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanAllocationSettlementEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanAllocationSettlementEvent> validator() {
		return new AbstractLoanAllocationSettlementEventValidator();
	}

	@Override
	public Validator<? super AbstractLoanAllocationSettlementEvent> typeFormatValidator() {
		return new AbstractLoanAllocationSettlementEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanAllocationSettlementEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanAllocationSettlementEventOnlyExistsValidator();
	}
}
