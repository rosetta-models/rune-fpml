package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanTradeEvent;
import fpml.confirmation.validation.AbstractLoanTradeEventTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanTradeEventValidator;
import fpml.confirmation.validation.exists.AbstractLoanTradeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLoanTradeEvent.class)
public class AbstractLoanTradeEventMeta implements RosettaMetaData<AbstractLoanTradeEvent> {

	@Override
	public List<Validator<? super AbstractLoanTradeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTradeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanTradeEvent> validator() {
		return new AbstractLoanTradeEventValidator();
	}

	@Override
	public Validator<? super AbstractLoanTradeEvent> typeFormatValidator() {
		return new AbstractLoanTradeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTradeEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradeEventOnlyExistsValidator();
	}
}
