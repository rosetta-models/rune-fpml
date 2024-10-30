package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ManualExercise;
import fpml.confirmation.validation.ManualExerciseTypeFormatValidator;
import fpml.confirmation.validation.ManualExerciseValidator;
import fpml.confirmation.validation.exists.ManualExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ManualExercise.class)
public class ManualExerciseMeta implements RosettaMetaData<ManualExercise> {

	@Override
	public List<Validator<? super ManualExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ManualExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ManualExercise> validator() {
		return new ManualExerciseValidator();
	}

	@Override
	public Validator<? super ManualExercise> typeFormatValidator() {
		return new ManualExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ManualExercise, Set<String>> onlyExistsValidator() {
		return new ManualExerciseOnlyExistsValidator();
	}
}
