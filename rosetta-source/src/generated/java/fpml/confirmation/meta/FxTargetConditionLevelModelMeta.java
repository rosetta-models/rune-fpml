package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.validation.FxTargetConditionLevelModelTypeFormatValidator;
import fpml.confirmation.validation.FxTargetConditionLevelModelValidator;
import fpml.confirmation.validation.exists.FxTargetConditionLevelModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetConditionLevelModel.class)
public class FxTargetConditionLevelModelMeta implements RosettaMetaData<FxTargetConditionLevelModel> {

	@Override
	public List<Validator<? super FxTargetConditionLevelModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTargetConditionLevelModel>create(fpml.confirmation.validation.datarule.FxTargetConditionLevelModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetConditionLevelModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetConditionLevelModel> validator() {
		return new FxTargetConditionLevelModelValidator();
	}

	@Override
	public Validator<? super FxTargetConditionLevelModel> typeFormatValidator() {
		return new FxTargetConditionLevelModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetConditionLevelModel, Set<String>> onlyExistsValidator() {
		return new FxTargetConditionLevelModelOnlyExistsValidator();
	}
}
