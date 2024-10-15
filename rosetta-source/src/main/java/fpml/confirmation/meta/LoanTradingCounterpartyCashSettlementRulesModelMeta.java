package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import fpml.confirmation.validation.LoanTradingCounterpartyCashSettlementRulesModelTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingCounterpartyCashSettlementRulesModelValidator;
import fpml.confirmation.validation.exists.LoanTradingCounterpartyCashSettlementRulesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingCounterpartyCashSettlementRulesModel.class)
public class LoanTradingCounterpartyCashSettlementRulesModelMeta implements RosettaMetaData<LoanTradingCounterpartyCashSettlementRulesModel> {

	@Override
	public List<Validator<? super LoanTradingCounterpartyCashSettlementRulesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCounterpartyCashSettlementRulesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingCounterpartyCashSettlementRulesModel> validator() {
		return new LoanTradingCounterpartyCashSettlementRulesModelValidator();
	}

	@Override
	public Validator<? super LoanTradingCounterpartyCashSettlementRulesModel> typeFormatValidator() {
		return new LoanTradingCounterpartyCashSettlementRulesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCounterpartyCashSettlementRulesModel, Set<String>> onlyExistsValidator() {
		return new LoanTradingCounterpartyCashSettlementRulesModelOnlyExistsValidator();
	}
}
