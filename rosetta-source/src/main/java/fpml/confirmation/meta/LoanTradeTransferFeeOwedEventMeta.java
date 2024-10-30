package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent;
import fpml.confirmation.validation.LoanTradeTransferFeeOwedEventTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeTransferFeeOwedEventValidator;
import fpml.confirmation.validation.exists.LoanTradeTransferFeeOwedEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradeTransferFeeOwedEvent.class)
public class LoanTradeTransferFeeOwedEventMeta implements RosettaMetaData<LoanTradeTransferFeeOwedEvent> {

	@Override
	public List<Validator<? super LoanTradeTransferFeeOwedEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeTransferFeeOwedEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeTransferFeeOwedEvent> validator() {
		return new LoanTradeTransferFeeOwedEventValidator();
	}

	@Override
	public Validator<? super LoanTradeTransferFeeOwedEvent> typeFormatValidator() {
		return new LoanTradeTransferFeeOwedEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeTransferFeeOwedEvent, Set<String>> onlyExistsValidator() {
		return new LoanTradeTransferFeeOwedEventOnlyExistsValidator();
	}
}
