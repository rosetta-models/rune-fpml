package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors;
import fpml.confirmation.validation.LoanTradingCounterpartySettlementFundingFactorsTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingCounterpartySettlementFundingFactorsValidator;
import fpml.confirmation.validation.exists.LoanTradingCounterpartySettlementFundingFactorsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingCounterpartySettlementFundingFactors.class)
public class LoanTradingCounterpartySettlementFundingFactorsMeta implements RosettaMetaData<LoanTradingCounterpartySettlementFundingFactors> {

	@Override
	public List<Validator<? super LoanTradingCounterpartySettlementFundingFactors>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCounterpartySettlementFundingFactors, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactors> validator() {
		return new LoanTradingCounterpartySettlementFundingFactorsValidator();
	}

	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactors> typeFormatValidator() {
		return new LoanTradingCounterpartySettlementFundingFactorsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCounterpartySettlementFundingFactors, Set<String>> onlyExistsValidator() {
		return new LoanTradingCounterpartySettlementFundingFactorsOnlyExistsValidator();
	}
}
