package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingOutstandingsAccrual;
import fpml.confirmation.validation.LoanTradingOutstandingsAccrualTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingOutstandingsAccrualValidator;
import fpml.confirmation.validation.exists.LoanTradingOutstandingsAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingOutstandingsAccrual.class)
public class LoanTradingOutstandingsAccrualMeta implements RosettaMetaData<LoanTradingOutstandingsAccrual> {

	@Override
	public List<Validator<? super LoanTradingOutstandingsAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingOutstandingsAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingOutstandingsAccrual> validator() {
		return new LoanTradingOutstandingsAccrualValidator();
	}

	@Override
	public Validator<? super LoanTradingOutstandingsAccrual> typeFormatValidator() {
		return new LoanTradingOutstandingsAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingOutstandingsAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingOutstandingsAccrualOnlyExistsValidator();
	}
}
