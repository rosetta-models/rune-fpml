package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DerivativeCalculationParametersModel;
import fpml.confirmation.validation.DerivativeCalculationParametersModelTypeFormatValidator;
import fpml.confirmation.validation.DerivativeCalculationParametersModelValidator;
import fpml.confirmation.validation.exists.DerivativeCalculationParametersModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeCalculationParametersModel.class)
public class DerivativeCalculationParametersModelMeta implements RosettaMetaData<DerivativeCalculationParametersModel> {

	@Override
	public List<Validator<? super DerivativeCalculationParametersModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DerivativeCalculationParametersModel>create(fpml.confirmation.validation.datarule.DerivativeCalculationParametersModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DerivativeCalculationParametersModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DerivativeCalculationParametersModel> validator() {
		return new DerivativeCalculationParametersModelValidator();
	}

	@Override
	public Validator<? super DerivativeCalculationParametersModel> typeFormatValidator() {
		return new DerivativeCalculationParametersModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeCalculationParametersModel, Set<String>> onlyExistsValidator() {
		return new DerivativeCalculationParametersModelOnlyExistsValidator();
	}
}
