package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanSettlementDateFinalizationEvent;
import fpml.confirmation.validation.LoanSettlementDateFinalizationEventTypeFormatValidator;
import fpml.confirmation.validation.LoanSettlementDateFinalizationEventValidator;
import fpml.confirmation.validation.exists.LoanSettlementDateFinalizationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanSettlementDateFinalizationEvent.class)
public class LoanSettlementDateFinalizationEventMeta implements RosettaMetaData<LoanSettlementDateFinalizationEvent> {

	@Override
	public List<Validator<? super LoanSettlementDateFinalizationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanSettlementDateFinalizationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanSettlementDateFinalizationEvent> validator() {
		return new LoanSettlementDateFinalizationEventValidator();
	}

	@Override
	public Validator<? super LoanSettlementDateFinalizationEvent> typeFormatValidator() {
		return new LoanSettlementDateFinalizationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanSettlementDateFinalizationEvent, Set<String>> onlyExistsValidator() {
		return new LoanSettlementDateFinalizationEventOnlyExistsValidator();
	}
}
