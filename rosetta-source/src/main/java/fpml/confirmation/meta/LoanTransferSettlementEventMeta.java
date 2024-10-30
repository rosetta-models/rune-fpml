package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransferSettlementEvent;
import fpml.confirmation.validation.LoanTransferSettlementEventTypeFormatValidator;
import fpml.confirmation.validation.LoanTransferSettlementEventValidator;
import fpml.confirmation.validation.exists.LoanTransferSettlementEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTransferSettlementEvent.class)
public class LoanTransferSettlementEventMeta implements RosettaMetaData<LoanTransferSettlementEvent> {

	@Override
	public List<Validator<? super LoanTransferSettlementEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTransferSettlementEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTransferSettlementEvent> validator() {
		return new LoanTransferSettlementEventValidator();
	}

	@Override
	public Validator<? super LoanTransferSettlementEvent> typeFormatValidator() {
		return new LoanTransferSettlementEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransferSettlementEvent, Set<String>> onlyExistsValidator() {
		return new LoanTransferSettlementEventOnlyExistsValidator();
	}
}
