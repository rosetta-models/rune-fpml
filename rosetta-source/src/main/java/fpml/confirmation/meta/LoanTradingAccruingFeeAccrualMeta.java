package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingAccruingFeeAccrual;
import fpml.confirmation.validation.LoanTradingAccruingFeeAccrualTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingAccruingFeeAccrualValidator;
import fpml.confirmation.validation.exists.LoanTradingAccruingFeeAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingAccruingFeeAccrual.class)
public class LoanTradingAccruingFeeAccrualMeta implements RosettaMetaData<LoanTradingAccruingFeeAccrual> {

	@Override
	public List<Validator<? super LoanTradingAccruingFeeAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingAccruingFeeAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingAccruingFeeAccrual> validator() {
		return new LoanTradingAccruingFeeAccrualValidator();
	}

	@Override
	public Validator<? super LoanTradingAccruingFeeAccrual> typeFormatValidator() {
		return new LoanTradingAccruingFeeAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingAccruingFeeAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingAccruingFeeAccrualOnlyExistsValidator();
	}
}
