package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MultipleExercise;
import fpml.confirmation.validation.MultipleExerciseTypeFormatValidator;
import fpml.confirmation.validation.MultipleExerciseValidator;
import fpml.confirmation.validation.exists.MultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MultipleExercise.class)
public class MultipleExerciseMeta implements RosettaMetaData<MultipleExercise> {

	@Override
	public List<Validator<? super MultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.MultipleExercise>create(fpml.confirmation.validation.datarule.MultipleExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MultipleExercise> validator() {
		return new MultipleExerciseValidator();
	}

	@Override
	public Validator<? super MultipleExercise> typeFormatValidator() {
		return new MultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultipleExercise, Set<String>> onlyExistsValidator() {
		return new MultipleExerciseOnlyExistsValidator();
	}
}
