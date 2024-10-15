package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCurveCharacteristicsModel;
import fpml.confirmation.validation.FxCurveCharacteristicsModelTypeFormatValidator;
import fpml.confirmation.validation.FxCurveCharacteristicsModelValidator;
import fpml.confirmation.validation.exists.FxCurveCharacteristicsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxCurveCharacteristicsModel.class)
public class FxCurveCharacteristicsModelMeta implements RosettaMetaData<FxCurveCharacteristicsModel> {

	@Override
	public List<Validator<? super FxCurveCharacteristicsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCurveCharacteristicsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCurveCharacteristicsModel> validator() {
		return new FxCurveCharacteristicsModelValidator();
	}

	@Override
	public Validator<? super FxCurveCharacteristicsModel> typeFormatValidator() {
		return new FxCurveCharacteristicsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCurveCharacteristicsModel, Set<String>> onlyExistsValidator() {
		return new FxCurveCharacteristicsModelOnlyExistsValidator();
	}
}
