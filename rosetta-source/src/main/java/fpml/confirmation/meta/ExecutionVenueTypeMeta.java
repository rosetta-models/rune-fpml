package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionVenueType;
import fpml.confirmation.validation.ExecutionVenueTypeTypeFormatValidator;
import fpml.confirmation.validation.ExecutionVenueTypeValidator;
import fpml.confirmation.validation.exists.ExecutionVenueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExecutionVenueType.class)
public class ExecutionVenueTypeMeta implements RosettaMetaData<ExecutionVenueType> {

	@Override
	public List<Validator<? super ExecutionVenueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionVenueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionVenueType> validator() {
		return new ExecutionVenueTypeValidator();
	}

	@Override
	public Validator<? super ExecutionVenueType> typeFormatValidator() {
		return new ExecutionVenueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionVenueType, Set<String>> onlyExistsValidator() {
		return new ExecutionVenueTypeOnlyExistsValidator();
	}
}
