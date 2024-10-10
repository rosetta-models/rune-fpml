package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PerturbationType;
import fpml.confirmation.validation.PerturbationTypeTypeFormatValidator;
import fpml.confirmation.validation.PerturbationTypeValidator;
import fpml.confirmation.validation.exists.PerturbationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PerturbationType.class)
public class PerturbationTypeMeta implements RosettaMetaData<PerturbationType> {

	@Override
	public List<Validator<? super PerturbationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PerturbationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PerturbationType> validator() {
		return new PerturbationTypeValidator();
	}

	@Override
	public Validator<? super PerturbationType> typeFormatValidator() {
		return new PerturbationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PerturbationType, Set<String>> onlyExistsValidator() {
		return new PerturbationTypeOnlyExistsValidator();
	}
}
