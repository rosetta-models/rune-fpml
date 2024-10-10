package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationModel;
import fpml.confirmation.validation.CorrelationModelTypeFormatValidator;
import fpml.confirmation.validation.CorrelationModelValidator;
import fpml.confirmation.validation.exists.CorrelationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CorrelationModel.class)
public class CorrelationModelMeta implements RosettaMetaData<CorrelationModel> {

	@Override
	public List<Validator<? super CorrelationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationModel> validator() {
		return new CorrelationModelValidator();
	}

	@Override
	public Validator<? super CorrelationModel> typeFormatValidator() {
		return new CorrelationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationModel, Set<String>> onlyExistsValidator() {
		return new CorrelationModelOnlyExistsValidator();
	}
}
