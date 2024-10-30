package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestAllocation;
import fpml.confirmation.validation.RequestAllocationTypeFormatValidator;
import fpml.confirmation.validation.RequestAllocationValidator;
import fpml.confirmation.validation.exists.RequestAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestAllocation.class)
public class RequestAllocationMeta implements RosettaMetaData<RequestAllocation> {

	@Override
	public List<Validator<? super RequestAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestAllocation> validator() {
		return new RequestAllocationValidator();
	}

	@Override
	public Validator<? super RequestAllocation> typeFormatValidator() {
		return new RequestAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestAllocation, Set<String>> onlyExistsValidator() {
		return new RequestAllocationOnlyExistsValidator();
	}
}
