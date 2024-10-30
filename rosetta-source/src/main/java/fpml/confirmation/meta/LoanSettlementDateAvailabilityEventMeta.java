package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent;
import fpml.confirmation.validation.LoanSettlementDateAvailabilityEventTypeFormatValidator;
import fpml.confirmation.validation.LoanSettlementDateAvailabilityEventValidator;
import fpml.confirmation.validation.exists.LoanSettlementDateAvailabilityEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanSettlementDateAvailabilityEvent.class)
public class LoanSettlementDateAvailabilityEventMeta implements RosettaMetaData<LoanSettlementDateAvailabilityEvent> {

	@Override
	public List<Validator<? super LoanSettlementDateAvailabilityEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanSettlementDateAvailabilityEvent>create(fpml.confirmation.validation.datarule.LoanSettlementDateAvailabilityEventChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanSettlementDateAvailabilityEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanSettlementDateAvailabilityEvent> validator() {
		return new LoanSettlementDateAvailabilityEventValidator();
	}

	@Override
	public Validator<? super LoanSettlementDateAvailabilityEvent> typeFormatValidator() {
		return new LoanSettlementDateAvailabilityEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanSettlementDateAvailabilityEvent, Set<String>> onlyExistsValidator() {
		return new LoanSettlementDateAvailabilityEventOnlyExistsValidator();
	}
}
