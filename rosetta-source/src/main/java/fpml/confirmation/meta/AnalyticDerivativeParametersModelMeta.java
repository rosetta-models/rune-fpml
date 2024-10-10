package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnalyticDerivativeParametersModel;
import fpml.confirmation.validation.AnalyticDerivativeParametersModelTypeFormatValidator;
import fpml.confirmation.validation.AnalyticDerivativeParametersModelValidator;
import fpml.confirmation.validation.exists.AnalyticDerivativeParametersModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AnalyticDerivativeParametersModel.class)
public class AnalyticDerivativeParametersModelMeta implements RosettaMetaData<AnalyticDerivativeParametersModel> {

	@Override
	public List<Validator<? super AnalyticDerivativeParametersModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnalyticDerivativeParametersModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AnalyticDerivativeParametersModel> validator() {
		return new AnalyticDerivativeParametersModelValidator();
	}

	@Override
	public Validator<? super AnalyticDerivativeParametersModel> typeFormatValidator() {
		return new AnalyticDerivativeParametersModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnalyticDerivativeParametersModel, Set<String>> onlyExistsValidator() {
		return new AnalyticDerivativeParametersModelOnlyExistsValidator();
	}
}
