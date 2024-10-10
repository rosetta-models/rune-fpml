package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.validation.FxEuropeanExerciseTypeFormatValidator;
import fpml.confirmation.validation.FxEuropeanExerciseValidator;
import fpml.confirmation.validation.exists.FxEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxEuropeanExercise.class)
public class FxEuropeanExerciseMeta implements RosettaMetaData<FxEuropeanExercise> {

	@Override
	public List<Validator<? super FxEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxEuropeanExercise> validator() {
		return new FxEuropeanExerciseValidator();
	}

	@Override
	public Validator<? super FxEuropeanExercise> typeFormatValidator() {
		return new FxEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new FxEuropeanExerciseOnlyExistsValidator();
	}
}
