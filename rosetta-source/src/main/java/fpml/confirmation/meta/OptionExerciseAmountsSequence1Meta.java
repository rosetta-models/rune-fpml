package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import fpml.confirmation.validation.OptionExerciseAmountsSequence1TypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountsSequence1Validator;
import fpml.confirmation.validation.exists.OptionExerciseAmountsSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseAmountsSequence1.class)
public class OptionExerciseAmountsSequence1Meta implements RosettaMetaData<OptionExerciseAmountsSequence1> {

	@Override
	public List<Validator<? super OptionExerciseAmountsSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountsSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence1> validator() {
		return new OptionExerciseAmountsSequence1Validator();
	}

	@Override
	public Validator<? super OptionExerciseAmountsSequence1> typeFormatValidator() {
		return new OptionExerciseAmountsSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountsSequence1, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountsSequence1OnlyExistsValidator();
	}
}
