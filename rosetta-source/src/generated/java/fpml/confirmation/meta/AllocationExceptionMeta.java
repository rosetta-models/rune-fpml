package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationException;
import fpml.confirmation.validation.AllocationExceptionTypeFormatValidator;
import fpml.confirmation.validation.AllocationExceptionValidator;
import fpml.confirmation.validation.exists.AllocationExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AllocationException.class)
public class AllocationExceptionMeta implements RosettaMetaData<AllocationException> {

	@Override
	public List<Validator<? super AllocationException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllocationException> validator() {
		return new AllocationExceptionValidator();
	}

	@Override
	public Validator<? super AllocationException> typeFormatValidator() {
		return new AllocationExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationException, Set<String>> onlyExistsValidator() {
		return new AllocationExceptionOnlyExistsValidator();
	}
}
