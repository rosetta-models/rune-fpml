package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeSettlementTask;
import fpml.confirmation.validation.LoanTradeSettlementTaskTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeSettlementTaskValidator;
import fpml.confirmation.validation.exists.LoanTradeSettlementTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeSettlementTask.class)
public class LoanTradeSettlementTaskMeta implements RosettaMetaData<LoanTradeSettlementTask> {

	@Override
	public List<Validator<? super LoanTradeSettlementTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeSettlementTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeSettlementTask> validator() {
		return new LoanTradeSettlementTaskValidator();
	}

	@Override
	public Validator<? super LoanTradeSettlementTask> typeFormatValidator() {
		return new LoanTradeSettlementTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeSettlementTask, Set<String>> onlyExistsValidator() {
		return new LoanTradeSettlementTaskOnlyExistsValidator();
	}
}
