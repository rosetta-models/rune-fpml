package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.validation.OptionExerciseTypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseValidator;
import fpml.confirmation.validation.exists.OptionExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionExercise.class)
public class OptionExerciseMeta implements RosettaMetaData<OptionExercise> {

	@Override
	public List<Validator<? super OptionExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionExercise>create(fpml.confirmation.validation.datarule.OptionExerciseChoice0.class),
			factory.<fpml.confirmation.OptionExercise>create(fpml.confirmation.validation.datarule.OptionExerciseChoice1.class),
			factory.<fpml.confirmation.OptionExercise>create(fpml.confirmation.validation.datarule.OptionExerciseChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExercise> validator() {
		return new OptionExerciseValidator();
	}

	@Override
	public Validator<? super OptionExercise> typeFormatValidator() {
		return new OptionExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExercise, Set<String>> onlyExistsValidator() {
		return new OptionExerciseOnlyExistsValidator();
	}
}
