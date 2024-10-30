package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityBermudaExercise;
import fpml.confirmation.validation.EquityBermudaExerciseTypeFormatValidator;
import fpml.confirmation.validation.EquityBermudaExerciseValidator;
import fpml.confirmation.validation.exists.EquityBermudaExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityBermudaExercise.class)
public class EquityBermudaExerciseMeta implements RosettaMetaData<EquityBermudaExercise> {

	@Override
	public List<Validator<? super EquityBermudaExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SharedAmericanExercise>create(fpml.confirmation.validation.datarule.SharedAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityBermudaExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityBermudaExercise> validator() {
		return new EquityBermudaExerciseValidator();
	}

	@Override
	public Validator<? super EquityBermudaExercise> typeFormatValidator() {
		return new EquityBermudaExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityBermudaExercise, Set<String>> onlyExistsValidator() {
		return new EquityBermudaExerciseOnlyExistsValidator();
	}
}
