package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.validation.EventValuationModelTypeFormatValidator;
import fpml.confirmation.validation.EventValuationModelValidator;
import fpml.confirmation.validation.exists.EventValuationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EventValuationModel.class)
public class EventValuationModelMeta implements RosettaMetaData<EventValuationModel> {

	@Override
	public List<Validator<? super EventValuationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventValuationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventValuationModel> validator() {
		return new EventValuationModelValidator();
	}

	@Override
	public Validator<? super EventValuationModel> typeFormatValidator() {
		return new EventValuationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventValuationModel, Set<String>> onlyExistsValidator() {
		return new EventValuationModelOnlyExistsValidator();
	}
}
