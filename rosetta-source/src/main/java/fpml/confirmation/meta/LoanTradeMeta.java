package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTrade;
import fpml.confirmation.validation.LoanTradeTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeValidator;
import fpml.confirmation.validation.exists.LoanTradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTrade.class)
public class LoanTradeMeta implements RosettaMetaData<LoanTrade> {

	@Override
	public List<Validator<? super LoanTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTrade> validator() {
		return new LoanTradeValidator();
	}

	@Override
	public Validator<? super LoanTrade> typeFormatValidator() {
		return new LoanTradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTrade, Set<String>> onlyExistsValidator() {
		return new LoanTradeOnlyExistsValidator();
	}
}
