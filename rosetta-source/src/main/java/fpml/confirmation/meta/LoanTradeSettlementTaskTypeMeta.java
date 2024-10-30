package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeSettlementTaskType;
import fpml.confirmation.validation.LoanTradeSettlementTaskTypeTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeSettlementTaskTypeValidator;
import fpml.confirmation.validation.exists.LoanTradeSettlementTaskTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradeSettlementTaskType.class)
public class LoanTradeSettlementTaskTypeMeta implements RosettaMetaData<LoanTradeSettlementTaskType> {

	@Override
	public List<Validator<? super LoanTradeSettlementTaskType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeSettlementTaskType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeSettlementTaskType> validator() {
		return new LoanTradeSettlementTaskTypeValidator();
	}

	@Override
	public Validator<? super LoanTradeSettlementTaskType> typeFormatValidator() {
		return new LoanTradeSettlementTaskTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeSettlementTaskType, Set<String>> onlyExistsValidator() {
		return new LoanTradeSettlementTaskTypeOnlyExistsValidator();
	}
}
