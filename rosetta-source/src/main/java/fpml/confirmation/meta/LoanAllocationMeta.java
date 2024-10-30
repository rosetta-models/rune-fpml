package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocation;
import fpml.confirmation.validation.LoanAllocationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationValidator;
import fpml.confirmation.validation.exists.LoanAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocation.class)
public class LoanAllocationMeta implements RosettaMetaData<LoanAllocation> {

	@Override
	public List<Validator<? super LoanAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocation> validator() {
		return new LoanAllocationValidator();
	}

	@Override
	public Validator<? super LoanAllocation> typeFormatValidator() {
		return new LoanAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocation, Set<String>> onlyExistsValidator() {
		return new LoanAllocationOnlyExistsValidator();
	}
}
