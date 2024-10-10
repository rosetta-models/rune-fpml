package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.validation.ChangeEventsBaseModelTypeFormatValidator;
import fpml.confirmation.validation.ChangeEventsBaseModelValidator;
import fpml.confirmation.validation.exists.ChangeEventsBaseModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ChangeEventsBaseModel.class)
public class ChangeEventsBaseModelMeta implements RosettaMetaData<ChangeEventsBaseModel> {

	@Override
	public List<Validator<? super ChangeEventsBaseModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ChangeEventsBaseModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ChangeEventsBaseModel> validator() {
		return new ChangeEventsBaseModelValidator();
	}

	@Override
	public Validator<? super ChangeEventsBaseModel> typeFormatValidator() {
		return new ChangeEventsBaseModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ChangeEventsBaseModel, Set<String>> onlyExistsValidator() {
		return new ChangeEventsBaseModelOnlyExistsValidator();
	}
}
