package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Resource;
import fpml.confirmation.validation.ResourceTypeFormatValidator;
import fpml.confirmation.validation.ResourceValidator;
import fpml.confirmation.validation.exists.ResourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Resource.class)
public class ResourceMeta implements RosettaMetaData<Resource> {

	@Override
	public List<Validator<? super Resource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Resource>create(fpml.confirmation.validation.datarule.ResourceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Resource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Resource> validator() {
		return new ResourceValidator();
	}

	@Override
	public Validator<? super Resource> typeFormatValidator() {
		return new ResourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Resource, Set<String>> onlyExistsValidator() {
		return new ResourceOnlyExistsValidator();
	}
}
