package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationSettlementTask;
import fpml.confirmation.validation.LoanAllocationSettlementTaskTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationSettlementTaskValidator;
import fpml.confirmation.validation.exists.LoanAllocationSettlementTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationSettlementTask.class)
public class LoanAllocationSettlementTaskMeta implements RosettaMetaData<LoanAllocationSettlementTask> {

	@Override
	public List<Validator<? super LoanAllocationSettlementTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationSettlementTask> validator() {
		return new LoanAllocationSettlementTaskValidator();
	}

	@Override
	public Validator<? super LoanAllocationSettlementTask> typeFormatValidator() {
		return new LoanAllocationSettlementTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementTask, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementTaskOnlyExistsValidator();
	}
}
