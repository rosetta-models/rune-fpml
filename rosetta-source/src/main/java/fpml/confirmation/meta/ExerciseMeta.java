package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Exercise;
import fpml.confirmation.validation.ExerciseTypeFormatValidator;
import fpml.confirmation.validation.ExerciseValidator;
import fpml.confirmation.validation.exists.ExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Exercise.class)
public class ExerciseMeta implements RosettaMetaData<Exercise> {

	@Override
	public List<Validator<? super Exercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Exercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Exercise> validator() {
		return new ExerciseValidator();
	}

	@Override
	public Validator<? super Exercise> typeFormatValidator() {
		return new ExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Exercise, Set<String>> onlyExistsValidator() {
		return new ExerciseOnlyExistsValidator();
	}
}
