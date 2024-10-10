package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import fpml.confirmation.validation.OptionExerciseAmountModelSequence2TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountModelSequence2Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountModelSequence2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionExerciseAmountModelSequence2.class)
public class OptionExerciseAmountModelSequence2Meta implements RosettaMetaData<OptionExerciseAmountModelSequence2> {

	@Override
	public List<Validator<? super OptionExerciseAmountModelSequence2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountModelSequence2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountModelSequence2> validator() {
		return new OptionExerciseAmountModelSequence2Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountModelSequence2> typeFormatValidator() {
		return new OptionExerciseAmountModelSequence2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountModelSequence2, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountModelSequence2OnlyExistsValidator();
	}
}
