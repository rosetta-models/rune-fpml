package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ResourceId;
import fpml.confirmation.validation.ResourceIdTypeFormatValidator;
import fpml.confirmation.validation.ResourceIdValidator;
import fpml.confirmation.validation.exists.ResourceIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ResourceId.class)
public class ResourceIdMeta implements RosettaMetaData<ResourceId> {

	@Override
	public List<Validator<? super ResourceId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResourceId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ResourceId> validator() {
		return new ResourceIdValidator();
	}

	@Override
	public Validator<? super ResourceId> typeFormatValidator() {
		return new ResourceIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResourceId, Set<String>> onlyExistsValidator() {
		return new ResourceIdOnlyExistsValidator();
	}
}
