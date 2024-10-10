package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ResourceType;
import fpml.confirmation.validation.ResourceTypeTypeFormatValidator;
import fpml.confirmation.validation.ResourceTypeValidator;
import fpml.confirmation.validation.exists.ResourceTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ResourceType.class)
public class ResourceTypeMeta implements RosettaMetaData<ResourceType> {

	@Override
	public List<Validator<? super ResourceType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResourceType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ResourceType> validator() {
		return new ResourceTypeValidator();
	}

	@Override
	public Validator<? super ResourceType> typeFormatValidator() {
		return new ResourceTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResourceType, Set<String>> onlyExistsValidator() {
		return new ResourceTypeOnlyExistsValidator();
	}
}
