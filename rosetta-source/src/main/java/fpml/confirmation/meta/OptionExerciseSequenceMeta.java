package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseSequence;
import fpml.confirmation.validation.OptionExerciseSequenceTypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseSequenceValidator;
import fpml.confirmation.validation.exists.OptionExerciseSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseSequence.class)
public class OptionExerciseSequenceMeta implements RosettaMetaData<OptionExerciseSequence> {

	@Override
	public List<Validator<? super OptionExerciseSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseSequence> validator() {
		return new OptionExerciseSequenceValidator();
	}

	@Override
	public Validator<? super OptionExerciseSequence> typeFormatValidator() {
		return new OptionExerciseSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseSequence, Set<String>> onlyExistsValidator() {
		return new OptionExerciseSequenceOnlyExistsValidator();
	}
}
