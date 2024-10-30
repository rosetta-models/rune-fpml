package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationSettlementTaskType;
import fpml.confirmation.validation.LoanAllocationSettlementTaskTypeTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationSettlementTaskTypeValidator;
import fpml.confirmation.validation.exists.LoanAllocationSettlementTaskTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationSettlementTaskType.class)
public class LoanAllocationSettlementTaskTypeMeta implements RosettaMetaData<LoanAllocationSettlementTaskType> {

	@Override
	public List<Validator<? super LoanAllocationSettlementTaskType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementTaskType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationSettlementTaskType> validator() {
		return new LoanAllocationSettlementTaskTypeValidator();
	}

	@Override
	public Validator<? super LoanAllocationSettlementTaskType> typeFormatValidator() {
		return new LoanAllocationSettlementTaskTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementTaskType, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementTaskTypeOnlyExistsValidator();
	}
}
