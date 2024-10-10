package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingCostOfCarry;
import fpml.confirmation.validation.LoanTradingCostOfCarryTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingCostOfCarryValidator;
import fpml.confirmation.validation.exists.LoanTradingCostOfCarryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingCostOfCarry.class)
public class LoanTradingCostOfCarryMeta implements RosettaMetaData<LoanTradingCostOfCarry> {

	@Override
	public List<Validator<? super LoanTradingCostOfCarry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCostOfCarry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingCostOfCarry> validator() {
		return new LoanTradingCostOfCarryValidator();
	}

	@Override
	public Validator<? super LoanTradingCostOfCarry> typeFormatValidator() {
		return new LoanTradingCostOfCarryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCostOfCarry, Set<String>> onlyExistsValidator() {
		return new LoanTradingCostOfCarryOnlyExistsValidator();
	}
}
