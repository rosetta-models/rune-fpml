package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxRateObservationModel;
import fpml.confirmation.validation.FxRateObservationModelTypeFormatValidator;
import fpml.confirmation.validation.FxRateObservationModelValidator;
import fpml.confirmation.validation.exists.FxRateObservationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxRateObservationModel.class)
public class FxRateObservationModelMeta implements RosettaMetaData<FxRateObservationModel> {

	@Override
	public List<Validator<? super FxRateObservationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRateObservationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxRateObservationModel> validator() {
		return new FxRateObservationModelValidator();
	}

	@Override
	public Validator<? super FxRateObservationModel> typeFormatValidator() {
		return new FxRateObservationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateObservationModel, Set<String>> onlyExistsValidator() {
		return new FxRateObservationModelOnlyExistsValidator();
	}
}
