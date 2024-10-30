package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.YieldCurveCharacteristicsModel;
import fpml.confirmation.validation.YieldCurveCharacteristicsModelTypeFormatValidator;
import fpml.confirmation.validation.YieldCurveCharacteristicsModelValidator;
import fpml.confirmation.validation.exists.YieldCurveCharacteristicsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=YieldCurveCharacteristicsModel.class)
public class YieldCurveCharacteristicsModelMeta implements RosettaMetaData<YieldCurveCharacteristicsModel> {

	@Override
	public List<Validator<? super YieldCurveCharacteristicsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurveCharacteristicsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super YieldCurveCharacteristicsModel> validator() {
		return new YieldCurveCharacteristicsModelValidator();
	}

	@Override
	public Validator<? super YieldCurveCharacteristicsModel> typeFormatValidator() {
		return new YieldCurveCharacteristicsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurveCharacteristicsModel, Set<String>> onlyExistsValidator() {
		return new YieldCurveCharacteristicsModelOnlyExistsValidator();
	}
}
