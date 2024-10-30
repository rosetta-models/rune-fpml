package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationNoSettlePeriodType;
import fpml.confirmation.validation.LoanAllocationNoSettlePeriodTypeTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationNoSettlePeriodTypeValidator;
import fpml.confirmation.validation.exists.LoanAllocationNoSettlePeriodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationNoSettlePeriodType.class)
public class LoanAllocationNoSettlePeriodTypeMeta implements RosettaMetaData<LoanAllocationNoSettlePeriodType> {

	@Override
	public List<Validator<? super LoanAllocationNoSettlePeriodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNoSettlePeriodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationNoSettlePeriodType> validator() {
		return new LoanAllocationNoSettlePeriodTypeValidator();
	}

	@Override
	public Validator<? super LoanAllocationNoSettlePeriodType> typeFormatValidator() {
		return new LoanAllocationNoSettlePeriodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNoSettlePeriodType, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNoSettlePeriodTypeOnlyExistsValidator();
	}
}
