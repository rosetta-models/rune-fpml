package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityEuropeanExercise;
import fpml.confirmation.validation.EquityEuropeanExerciseTypeFormatValidator;
import fpml.confirmation.validation.EquityEuropeanExerciseValidator;
import fpml.confirmation.validation.exists.EquityEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityEuropeanExercise.class)
public class EquityEuropeanExerciseMeta implements RosettaMetaData<EquityEuropeanExercise> {

	@Override
	public List<Validator<? super EquityEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityEuropeanExercise> validator() {
		return new EquityEuropeanExerciseValidator();
	}

	@Override
	public Validator<? super EquityEuropeanExercise> typeFormatValidator() {
		return new EquityEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new EquityEuropeanExerciseOnlyExistsValidator();
	}
}
