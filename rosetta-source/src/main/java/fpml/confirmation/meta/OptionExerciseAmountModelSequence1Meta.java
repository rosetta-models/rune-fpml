package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountModelSequence1;
import fpml.confirmation.validation.OptionExerciseAmountModelSequence1TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountModelSequence1Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountModelSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseAmountModelSequence1.class)
public class OptionExerciseAmountModelSequence1Meta implements RosettaMetaData<OptionExerciseAmountModelSequence1> {

	@Override
	public List<Validator<? super OptionExerciseAmountModelSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountModelSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountModelSequence1> validator() {
		return new OptionExerciseAmountModelSequence1Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountModelSequence1> typeFormatValidator() {
		return new OptionExerciseAmountModelSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountModelSequence1, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountModelSequence1OnlyExistsValidator();
	}
}
