package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.validation.FxAccrualConditionLevelModelTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualConditionLevelModelValidator;
import fpml.confirmation.validation.exists.FxAccrualConditionLevelModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualConditionLevelModel.class)
public class FxAccrualConditionLevelModelMeta implements RosettaMetaData<FxAccrualConditionLevelModel> {

	@Override
	public List<Validator<? super FxAccrualConditionLevelModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualConditionLevelModel>create(fpml.confirmation.validation.datarule.FxAccrualConditionLevelModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualConditionLevelModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualConditionLevelModel> validator() {
		return new FxAccrualConditionLevelModelValidator();
	}

	@Override
	public Validator<? super FxAccrualConditionLevelModel> typeFormatValidator() {
		return new FxAccrualConditionLevelModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualConditionLevelModel, Set<String>> onlyExistsValidator() {
		return new FxAccrualConditionLevelModelOnlyExistsValidator();
	}
}
