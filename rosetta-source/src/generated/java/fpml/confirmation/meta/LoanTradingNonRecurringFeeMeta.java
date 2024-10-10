package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingNonRecurringFee;
import fpml.confirmation.validation.LoanTradingNonRecurringFeeTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingNonRecurringFeeValidator;
import fpml.confirmation.validation.exists.LoanTradingNonRecurringFeeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingNonRecurringFee.class)
public class LoanTradingNonRecurringFeeMeta implements RosettaMetaData<LoanTradingNonRecurringFee> {

	@Override
	public List<Validator<? super LoanTradingNonRecurringFee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanTradingNonRecurringFee>create(fpml.confirmation.validation.datarule.LoanTradingNonRecurringFeeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradingNonRecurringFee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingNonRecurringFee> validator() {
		return new LoanTradingNonRecurringFeeValidator();
	}

	@Override
	public Validator<? super LoanTradingNonRecurringFee> typeFormatValidator() {
		return new LoanTradingNonRecurringFeeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingNonRecurringFee, Set<String>> onlyExistsValidator() {
		return new LoanTradingNonRecurringFeeOnlyExistsValidator();
	}
}
