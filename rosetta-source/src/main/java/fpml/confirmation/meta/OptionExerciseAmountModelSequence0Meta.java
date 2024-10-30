package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountModelSequence0;
import fpml.confirmation.validation.OptionExerciseAmountModelSequence0TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountModelSequence0Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountModelSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseAmountModelSequence0.class)
public class OptionExerciseAmountModelSequence0Meta implements RosettaMetaData<OptionExerciseAmountModelSequence0> {

	@Override
	public List<Validator<? super OptionExerciseAmountModelSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountModelSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountModelSequence0> validator() {
		return new OptionExerciseAmountModelSequence0Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountModelSequence0> typeFormatValidator() {
		return new OptionExerciseAmountModelSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountModelSequence0, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountModelSequence0OnlyExistsValidator();
	}
}
