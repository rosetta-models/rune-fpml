package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SharedAmericanExercise;
import fpml.confirmation.validation.SharedAmericanExerciseTypeFormatValidator;
import fpml.confirmation.validation.SharedAmericanExerciseValidator;
import fpml.confirmation.validation.exists.SharedAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SharedAmericanExercise.class)
public class SharedAmericanExerciseMeta implements RosettaMetaData<SharedAmericanExercise> {

	@Override
	public List<Validator<? super SharedAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SharedAmericanExercise>create(fpml.confirmation.validation.datarule.SharedAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SharedAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SharedAmericanExercise> validator() {
		return new SharedAmericanExerciseValidator();
	}

	@Override
	public Validator<? super SharedAmericanExercise> typeFormatValidator() {
		return new SharedAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SharedAmericanExercise, Set<String>> onlyExistsValidator() {
		return new SharedAmericanExerciseOnlyExistsValidator();
	}
}
