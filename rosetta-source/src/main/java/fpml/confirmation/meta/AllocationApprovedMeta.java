package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationApproved;
import fpml.confirmation.validation.AllocationApprovedTypeFormatValidator;
import fpml.confirmation.validation.AllocationApprovedValidator;
import fpml.confirmation.validation.exists.AllocationApprovedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AllocationApproved.class)
public class AllocationApprovedMeta implements RosettaMetaData<AllocationApproved> {

	@Override
	public List<Validator<? super AllocationApproved>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationApproved, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllocationApproved> validator() {
		return new AllocationApprovedValidator();
	}

	@Override
	public Validator<? super AllocationApproved> typeFormatValidator() {
		return new AllocationApprovedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationApproved, Set<String>> onlyExistsValidator() {
		return new AllocationApprovedOnlyExistsValidator();
	}
}
