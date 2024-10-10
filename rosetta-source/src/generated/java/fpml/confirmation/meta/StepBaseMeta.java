package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StepBase;
import fpml.confirmation.validation.StepBaseTypeFormatValidator;
import fpml.confirmation.validation.StepBaseValidator;
import fpml.confirmation.validation.exists.StepBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StepBase.class)
public class StepBaseMeta implements RosettaMetaData<StepBase> {

	@Override
	public List<Validator<? super StepBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StepBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StepBase> validator() {
		return new StepBaseValidator();
	}

	@Override
	public Validator<? super StepBase> typeFormatValidator() {
		return new StepBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StepBase, Set<String>> onlyExistsValidator() {
		return new StepBaseOnlyExistsValidator();
	}
}
