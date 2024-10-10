package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Step;
import fpml.confirmation.validation.StepTypeFormatValidator;
import fpml.confirmation.validation.StepValidator;
import fpml.confirmation.validation.exists.StepOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Step.class)
public class StepMeta implements RosettaMetaData<Step> {

	@Override
	public List<Validator<? super Step>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Step, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Step> validator() {
		return new StepValidator();
	}

	@Override
	public Validator<? super Step> typeFormatValidator() {
		return new StepTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Step, Set<String>> onlyExistsValidator() {
		return new StepOnlyExistsValidator();
	}
}
