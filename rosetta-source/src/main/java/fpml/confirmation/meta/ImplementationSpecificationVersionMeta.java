package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ImplementationSpecificationVersion;
import fpml.confirmation.validation.ImplementationSpecificationVersionTypeFormatValidator;
import fpml.confirmation.validation.ImplementationSpecificationVersionValidator;
import fpml.confirmation.validation.exists.ImplementationSpecificationVersionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ImplementationSpecificationVersion.class)
public class ImplementationSpecificationVersionMeta implements RosettaMetaData<ImplementationSpecificationVersion> {

	@Override
	public List<Validator<? super ImplementationSpecificationVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ImplementationSpecificationVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ImplementationSpecificationVersion> validator() {
		return new ImplementationSpecificationVersionValidator();
	}

	@Override
	public Validator<? super ImplementationSpecificationVersion> typeFormatValidator() {
		return new ImplementationSpecificationVersionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ImplementationSpecificationVersion, Set<String>> onlyExistsValidator() {
		return new ImplementationSpecificationVersionOnlyExistsValidator();
	}
}
