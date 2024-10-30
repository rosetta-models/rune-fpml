package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAmericanExercise;
import fpml.confirmation.validation.FxAmericanExerciseTypeFormatValidator;
import fpml.confirmation.validation.FxAmericanExerciseValidator;
import fpml.confirmation.validation.exists.FxAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAmericanExercise.class)
public class FxAmericanExerciseMeta implements RosettaMetaData<FxAmericanExercise> {

	@Override
	public List<Validator<? super FxAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAmericanExercise> validator() {
		return new FxAmericanExerciseValidator();
	}

	@Override
	public Validator<? super FxAmericanExercise> typeFormatValidator() {
		return new FxAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAmericanExercise, Set<String>> onlyExistsValidator() {
		return new FxAmericanExerciseOnlyExistsValidator();
	}
}
