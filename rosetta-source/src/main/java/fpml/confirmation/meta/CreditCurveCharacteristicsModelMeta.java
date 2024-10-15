package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditCurveCharacteristicsModel;
import fpml.confirmation.validation.CreditCurveCharacteristicsModelTypeFormatValidator;
import fpml.confirmation.validation.CreditCurveCharacteristicsModelValidator;
import fpml.confirmation.validation.exists.CreditCurveCharacteristicsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditCurveCharacteristicsModel.class)
public class CreditCurveCharacteristicsModelMeta implements RosettaMetaData<CreditCurveCharacteristicsModel> {

	@Override
	public List<Validator<? super CreditCurveCharacteristicsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditCurveCharacteristicsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditCurveCharacteristicsModel> validator() {
		return new CreditCurveCharacteristicsModelValidator();
	}

	@Override
	public Validator<? super CreditCurveCharacteristicsModel> typeFormatValidator() {
		return new CreditCurveCharacteristicsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditCurveCharacteristicsModel, Set<String>> onlyExistsValidator() {
		return new CreditCurveCharacteristicsModelOnlyExistsValidator();
	}
}
