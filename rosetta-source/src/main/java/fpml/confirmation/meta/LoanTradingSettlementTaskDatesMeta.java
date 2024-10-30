package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.validation.LoanTradingSettlementTaskDatesTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingSettlementTaskDatesValidator;
import fpml.confirmation.validation.exists.LoanTradingSettlementTaskDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingSettlementTaskDates.class)
public class LoanTradingSettlementTaskDatesMeta implements RosettaMetaData<LoanTradingSettlementTaskDates> {

	@Override
	public List<Validator<? super LoanTradingSettlementTaskDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingSettlementTaskDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingSettlementTaskDates> validator() {
		return new LoanTradingSettlementTaskDatesValidator();
	}

	@Override
	public Validator<? super LoanTradingSettlementTaskDates> typeFormatValidator() {
		return new LoanTradingSettlementTaskDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingSettlementTaskDates, Set<String>> onlyExistsValidator() {
		return new LoanTradingSettlementTaskDatesOnlyExistsValidator();
	}
}
