package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExerciseFee;
import fpml.confirmation.validation.ExerciseFeeTypeFormatValidator;
import fpml.confirmation.validation.ExerciseFeeValidator;
import fpml.confirmation.validation.exists.ExerciseFeeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExerciseFee.class)
public class ExerciseFeeMeta implements RosettaMetaData<ExerciseFee> {

	@Override
	public List<Validator<? super ExerciseFee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExerciseFee>create(fpml.confirmation.validation.datarule.ExerciseFeeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseFee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExerciseFee> validator() {
		return new ExerciseFeeValidator();
	}

	@Override
	public Validator<? super ExerciseFee> typeFormatValidator() {
		return new ExerciseFeeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseFee, Set<String>> onlyExistsValidator() {
		return new ExerciseFeeOnlyExistsValidator();
	}
}
