package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SubstitutionDerivativeParametersModel;
import fpml.confirmation.validation.SubstitutionDerivativeParametersModelTypeFormatValidator;
import fpml.confirmation.validation.SubstitutionDerivativeParametersModelValidator;
import fpml.confirmation.validation.exists.SubstitutionDerivativeParametersModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SubstitutionDerivativeParametersModel.class)
public class SubstitutionDerivativeParametersModelMeta implements RosettaMetaData<SubstitutionDerivativeParametersModel> {

	@Override
	public List<Validator<? super SubstitutionDerivativeParametersModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SubstitutionDerivativeParametersModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SubstitutionDerivativeParametersModel> validator() {
		return new SubstitutionDerivativeParametersModelValidator();
	}

	@Override
	public Validator<? super SubstitutionDerivativeParametersModel> typeFormatValidator() {
		return new SubstitutionDerivativeParametersModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SubstitutionDerivativeParametersModel, Set<String>> onlyExistsValidator() {
		return new SubstitutionDerivativeParametersModelOnlyExistsValidator();
	}
}
