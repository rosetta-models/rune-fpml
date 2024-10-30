package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartialExercise;
import fpml.confirmation.validation.PartialExerciseTypeFormatValidator;
import fpml.confirmation.validation.PartialExerciseValidator;
import fpml.confirmation.validation.exists.PartialExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartialExercise.class)
public class PartialExerciseMeta implements RosettaMetaData<PartialExercise> {

	@Override
	public List<Validator<? super PartialExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartialExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartialExercise> validator() {
		return new PartialExerciseValidator();
	}

	@Override
	public Validator<? super PartialExercise> typeFormatValidator() {
		return new PartialExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartialExercise, Set<String>> onlyExistsValidator() {
		return new PartialExerciseOnlyExistsValidator();
	}
}
