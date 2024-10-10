package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual;
import fpml.confirmation.validation.LoanTradingLetterOfCreditAccrualTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingLetterOfCreditAccrualValidator;
import fpml.confirmation.validation.exists.LoanTradingLetterOfCreditAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingLetterOfCreditAccrual.class)
public class LoanTradingLetterOfCreditAccrualMeta implements RosettaMetaData<LoanTradingLetterOfCreditAccrual> {

	@Override
	public List<Validator<? super LoanTradingLetterOfCreditAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingLetterOfCreditAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingLetterOfCreditAccrual> validator() {
		return new LoanTradingLetterOfCreditAccrualValidator();
	}

	@Override
	public Validator<? super LoanTradingLetterOfCreditAccrual> typeFormatValidator() {
		return new LoanTradingLetterOfCreditAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingLetterOfCreditAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingLetterOfCreditAccrualOnlyExistsValidator();
	}
}
