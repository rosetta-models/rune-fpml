package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence;
import fpml.confirmation.validation.LoanTradingCounterpartySettlementFundingFactorsSequenceTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingCounterpartySettlementFundingFactorsSequenceValidator;
import fpml.confirmation.validation.exists.LoanTradingCounterpartySettlementFundingFactorsSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingCounterpartySettlementFundingFactorsSequence.class)
public class LoanTradingCounterpartySettlementFundingFactorsSequenceMeta implements RosettaMetaData<LoanTradingCounterpartySettlementFundingFactorsSequence> {

	@Override
	public List<Validator<? super LoanTradingCounterpartySettlementFundingFactorsSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCounterpartySettlementFundingFactorsSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactorsSequence> validator() {
		return new LoanTradingCounterpartySettlementFundingFactorsSequenceValidator();
	}

	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactorsSequence> typeFormatValidator() {
		return new LoanTradingCounterpartySettlementFundingFactorsSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCounterpartySettlementFundingFactorsSequence, Set<String>> onlyExistsValidator() {
		return new LoanTradingCounterpartySettlementFundingFactorsSequenceOnlyExistsValidator();
	}
}
