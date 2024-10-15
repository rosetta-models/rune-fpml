package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestAllocationRetracted;
import fpml.confirmation.validation.RequestAllocationRetractedTypeFormatValidator;
import fpml.confirmation.validation.RequestAllocationRetractedValidator;
import fpml.confirmation.validation.exists.RequestAllocationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RequestAllocationRetracted.class)
public class RequestAllocationRetractedMeta implements RosettaMetaData<RequestAllocationRetracted> {

	@Override
	public List<Validator<? super RequestAllocationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestAllocationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestAllocationRetracted> validator() {
		return new RequestAllocationRetractedValidator();
	}

	@Override
	public Validator<? super RequestAllocationRetracted> typeFormatValidator() {
		return new RequestAllocationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestAllocationRetracted, Set<String>> onlyExistsValidator() {
		return new RequestAllocationRetractedOnlyExistsValidator();
	}
}
