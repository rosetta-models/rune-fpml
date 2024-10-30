package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel;
import fpml.confirmation.validation.FiniteDifferenceDerivativeParametersModelTypeFormatValidator;
import fpml.confirmation.validation.FiniteDifferenceDerivativeParametersModelValidator;
import fpml.confirmation.validation.exists.FiniteDifferenceDerivativeParametersModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FiniteDifferenceDerivativeParametersModel.class)
public class FiniteDifferenceDerivativeParametersModelMeta implements RosettaMetaData<FiniteDifferenceDerivativeParametersModel> {

	@Override
	public List<Validator<? super FiniteDifferenceDerivativeParametersModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FiniteDifferenceDerivativeParametersModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FiniteDifferenceDerivativeParametersModel> validator() {
		return new FiniteDifferenceDerivativeParametersModelValidator();
	}

	@Override
	public Validator<? super FiniteDifferenceDerivativeParametersModel> typeFormatValidator() {
		return new FiniteDifferenceDerivativeParametersModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FiniteDifferenceDerivativeParametersModel, Set<String>> onlyExistsValidator() {
		return new FiniteDifferenceDerivativeParametersModelOnlyExistsValidator();
	}
}
