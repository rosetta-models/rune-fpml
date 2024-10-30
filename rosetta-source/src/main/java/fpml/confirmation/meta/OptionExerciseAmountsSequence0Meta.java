package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import fpml.confirmation.validation.OptionExerciseAmountsSequence0TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountsSequence0Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountsSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseAmountsSequence0.class)
public class OptionExerciseAmountsSequence0Meta implements RosettaMetaData<OptionExerciseAmountsSequence0> {

	@Override
	public List<Validator<? super OptionExerciseAmountsSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountsSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence0> validator() {
		return new OptionExerciseAmountsSequence0Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence0> typeFormatValidator() {
		return new OptionExerciseAmountsSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountsSequence0, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountsSequence0OnlyExistsValidator();
	}
}
