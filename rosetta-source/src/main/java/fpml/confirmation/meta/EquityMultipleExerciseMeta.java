package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityMultipleExercise;
import fpml.confirmation.validation.EquityMultipleExerciseTypeFormatValidator;
import fpml.confirmation.validation.EquityMultipleExerciseValidator;
import fpml.confirmation.validation.exists.EquityMultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityMultipleExercise.class)
public class EquityMultipleExerciseMeta implements RosettaMetaData<EquityMultipleExercise> {

	@Override
	public List<Validator<? super EquityMultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityMultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityMultipleExercise> validator() {
		return new EquityMultipleExerciseValidator();
	}

	@Override
	public Validator<? super EquityMultipleExercise> typeFormatValidator() {
		return new EquityMultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityMultipleExercise, Set<String>> onlyExistsValidator() {
		return new EquityMultipleExerciseOnlyExistsValidator();
	}
}
