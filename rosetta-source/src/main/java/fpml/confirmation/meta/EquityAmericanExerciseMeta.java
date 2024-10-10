package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityAmericanExercise;
import fpml.confirmation.validation.EquityAmericanExerciseTypeFormatValidator;
import fpml.confirmation.validation.EquityAmericanExerciseValidator;
import fpml.confirmation.validation.exists.EquityAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityAmericanExercise.class)
public class EquityAmericanExerciseMeta implements RosettaMetaData<EquityAmericanExercise> {

	@Override
	public List<Validator<? super EquityAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SharedAmericanExercise>create(fpml.confirmation.validation.datarule.SharedAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityAmericanExercise> validator() {
		return new EquityAmericanExerciseValidator();
	}

	@Override
	public Validator<? super EquityAmericanExercise> typeFormatValidator() {
		return new EquityAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityAmericanExercise, Set<String>> onlyExistsValidator() {
		return new EquityAmericanExerciseOnlyExistsValidator();
	}
}
