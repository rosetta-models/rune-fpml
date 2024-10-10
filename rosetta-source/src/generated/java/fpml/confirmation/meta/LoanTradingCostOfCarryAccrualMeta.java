package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingCostOfCarryAccrual;
import fpml.confirmation.validation.LoanTradingCostOfCarryAccrualTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingCostOfCarryAccrualValidator;
import fpml.confirmation.validation.exists.LoanTradingCostOfCarryAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingCostOfCarryAccrual.class)
public class LoanTradingCostOfCarryAccrualMeta implements RosettaMetaData<LoanTradingCostOfCarryAccrual> {

	@Override
	public List<Validator<? super LoanTradingCostOfCarryAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanTradingCostOfCarryAccrual>create(fpml.confirmation.validation.datarule.LoanTradingCostOfCarryAccrualChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCostOfCarryAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingCostOfCarryAccrual> validator() {
		return new LoanTradingCostOfCarryAccrualValidator();
	}

	@Override
	public Validator<? super LoanTradingCostOfCarryAccrual> typeFormatValidator() {
		return new LoanTradingCostOfCarryAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCostOfCarryAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingCostOfCarryAccrualOnlyExistsValidator();
	}
}
