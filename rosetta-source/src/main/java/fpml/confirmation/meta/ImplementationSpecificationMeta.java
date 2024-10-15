package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ImplementationSpecification;
import fpml.confirmation.validation.ImplementationSpecificationTypeFormatValidator;
import fpml.confirmation.validation.ImplementationSpecificationValidator;
import fpml.confirmation.validation.exists.ImplementationSpecificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ImplementationSpecification.class)
public class ImplementationSpecificationMeta implements RosettaMetaData<ImplementationSpecification> {

	@Override
	public List<Validator<? super ImplementationSpecification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ImplementationSpecification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ImplementationSpecification> validator() {
		return new ImplementationSpecificationValidator();
	}

	@Override
	public Validator<? super ImplementationSpecification> typeFormatValidator() {
		return new ImplementationSpecificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ImplementationSpecification, Set<String>> onlyExistsValidator() {
		return new ImplementationSpecificationOnlyExistsValidator();
	}
}
