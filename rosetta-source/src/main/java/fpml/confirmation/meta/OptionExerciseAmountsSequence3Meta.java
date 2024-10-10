package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import fpml.confirmation.validation.OptionExerciseAmountsSequence3TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountsSequence3Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountsSequence3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionExerciseAmountsSequence3.class)
public class OptionExerciseAmountsSequence3Meta implements RosettaMetaData<OptionExerciseAmountsSequence3> {

	@Override
	public List<Validator<? super OptionExerciseAmountsSequence3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountsSequence3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence3> validator() {
		return new OptionExerciseAmountsSequence3Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence3> typeFormatValidator() {
		return new OptionExerciseAmountsSequence3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountsSequence3, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountsSequence3OnlyExistsValidator();
	}
}
