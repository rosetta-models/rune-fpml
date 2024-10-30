package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanTrade;
import fpml.confirmation.validation.AbstractLoanTradeTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanTradeValidator;
import fpml.confirmation.validation.exists.AbstractLoanTradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLoanTrade.class)
public class AbstractLoanTradeMeta implements RosettaMetaData<AbstractLoanTrade> {

	@Override
	public List<Validator<? super AbstractLoanTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanTrade> validator() {
		return new AbstractLoanTradeValidator();
	}

	@Override
	public Validator<? super AbstractLoanTrade> typeFormatValidator() {
		return new AbstractLoanTradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTrade, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradeOnlyExistsValidator();
	}
}
