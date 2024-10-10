package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDigitalAmericanExercise;
import fpml.confirmation.validation.FxDigitalAmericanExerciseTypeFormatValidator;
import fpml.confirmation.validation.FxDigitalAmericanExerciseValidator;
import fpml.confirmation.validation.exists.FxDigitalAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxDigitalAmericanExercise.class)
public class FxDigitalAmericanExerciseMeta implements RosettaMetaData<FxDigitalAmericanExercise> {

	@Override
	public List<Validator<? super FxDigitalAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDigitalAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDigitalAmericanExercise> validator() {
		return new FxDigitalAmericanExerciseValidator();
	}

	@Override
	public Validator<? super FxDigitalAmericanExercise> typeFormatValidator() {
		return new FxDigitalAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDigitalAmericanExercise, Set<String>> onlyExistsValidator() {
		return new FxDigitalAmericanExerciseOnlyExistsValidator();
	}
}
