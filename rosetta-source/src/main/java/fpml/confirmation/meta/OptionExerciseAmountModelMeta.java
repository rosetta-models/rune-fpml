package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.validation.OptionExerciseAmountModelTypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountModelValidator;
import fpml.confirmation.validation.exists.OptionExerciseAmountModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExerciseAmountModel.class)
public class OptionExerciseAmountModelMeta implements RosettaMetaData<OptionExerciseAmountModel> {

	@Override
	public List<Validator<? super OptionExerciseAmountModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionExerciseAmountModel>create(fpml.confirmation.validation.datarule.OptionExerciseAmountModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmountModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmountModel> validator() {
		return new OptionExerciseAmountModelValidator();
	}

	@Override
	public Validator<? super OptionExerciseAmountModel> typeFormatValidator() {
		return new OptionExerciseAmountModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmountModel, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountModelOnlyExistsValidator();
	}
}
