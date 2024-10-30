package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import fpml.confirmation.validation.OptionExerciseAmountsSequence2TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountsSequence2Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountsSequence2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseAmountsSequence2.class)
public class OptionExerciseAmountsSequence2Meta implements RosettaMetaData<OptionExerciseAmountsSequence2> {

	@Override
	public List<Validator<? super OptionExerciseAmountsSequence2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountsSequence2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence2> validator() {
		return new OptionExerciseAmountsSequence2Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence2> typeFormatValidator() {
		return new OptionExerciseAmountsSequence2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountsSequence2, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountsSequence2OnlyExistsValidator();
	}
}
