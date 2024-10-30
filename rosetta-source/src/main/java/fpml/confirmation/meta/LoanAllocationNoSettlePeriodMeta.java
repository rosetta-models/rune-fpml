package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationNoSettlePeriod;
import fpml.confirmation.validation.LoanAllocationNoSettlePeriodTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationNoSettlePeriodValidator;
import fpml.confirmation.validation.exists.LoanAllocationNoSettlePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationNoSettlePeriod.class)
public class LoanAllocationNoSettlePeriodMeta implements RosettaMetaData<LoanAllocationNoSettlePeriod> {

	@Override
	public List<Validator<? super LoanAllocationNoSettlePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNoSettlePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationNoSettlePeriod> validator() {
		return new LoanAllocationNoSettlePeriodValidator();
	}

	@Override
	public Validator<? super LoanAllocationNoSettlePeriod> typeFormatValidator() {
		return new LoanAllocationNoSettlePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNoSettlePeriod, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNoSettlePeriodOnlyExistsValidator();
	}
}
