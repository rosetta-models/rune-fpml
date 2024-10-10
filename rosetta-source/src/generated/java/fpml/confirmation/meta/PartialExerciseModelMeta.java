package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartialExerciseModel;
import fpml.confirmation.validation.PartialExerciseModelTypeFormatValidator;
import fpml.confirmation.validation.PartialExerciseModelValidator;
import fpml.confirmation.validation.exists.PartialExerciseModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartialExerciseModel.class)
public class PartialExerciseModelMeta implements RosettaMetaData<PartialExerciseModel> {

	@Override
	public List<Validator<? super PartialExerciseModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PartialExerciseModel>create(fpml.confirmation.validation.datarule.PartialExerciseModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartialExerciseModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartialExerciseModel> validator() {
		return new PartialExerciseModelValidator();
	}

	@Override
	public Validator<? super PartialExerciseModel> typeFormatValidator() {
		return new PartialExerciseModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartialExerciseModel, Set<String>> onlyExistsValidator() {
		return new PartialExerciseModelOnlyExistsValidator();
	}
}
