package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingDelayedCompensation;
import fpml.confirmation.validation.LoanTradingDelayedCompensationTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingDelayedCompensationValidator;
import fpml.confirmation.validation.exists.LoanTradingDelayedCompensationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingDelayedCompensation.class)
public class LoanTradingDelayedCompensationMeta implements RosettaMetaData<LoanTradingDelayedCompensation> {

	@Override
	public List<Validator<? super LoanTradingDelayedCompensation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingDelayedCompensation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingDelayedCompensation> validator() {
		return new LoanTradingDelayedCompensationValidator();
	}

	@Override
	public Validator<? super LoanTradingDelayedCompensation> typeFormatValidator() {
		return new LoanTradingDelayedCompensationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingDelayedCompensation, Set<String>> onlyExistsValidator() {
		return new LoanTradingDelayedCompensationOnlyExistsValidator();
	}
}
