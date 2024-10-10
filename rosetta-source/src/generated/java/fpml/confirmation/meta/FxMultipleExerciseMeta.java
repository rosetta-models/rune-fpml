package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxMultipleExercise;
import fpml.confirmation.validation.FxMultipleExerciseTypeFormatValidator;
import fpml.confirmation.validation.FxMultipleExerciseValidator;
import fpml.confirmation.validation.exists.FxMultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxMultipleExercise.class)
public class FxMultipleExerciseMeta implements RosettaMetaData<FxMultipleExercise> {

	@Override
	public List<Validator<? super FxMultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxMultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxMultipleExercise> validator() {
		return new FxMultipleExerciseValidator();
	}

	@Override
	public Validator<? super FxMultipleExercise> typeFormatValidator() {
		return new FxMultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxMultipleExercise, Set<String>> onlyExistsValidator() {
		return new FxMultipleExerciseOnlyExistsValidator();
	}
}
