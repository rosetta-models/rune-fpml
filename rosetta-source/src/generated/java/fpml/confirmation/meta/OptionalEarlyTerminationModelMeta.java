package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionalEarlyTerminationModel;
import fpml.confirmation.validation.OptionalEarlyTerminationModelTypeFormatValidator;
import fpml.confirmation.validation.OptionalEarlyTerminationModelValidator;
import fpml.confirmation.validation.exists.OptionalEarlyTerminationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionalEarlyTerminationModel.class)
public class OptionalEarlyTerminationModelMeta implements RosettaMetaData<OptionalEarlyTerminationModel> {

	@Override
	public List<Validator<? super OptionalEarlyTerminationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionalEarlyTerminationModel>create(fpml.confirmation.validation.datarule.OptionalEarlyTerminationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionalEarlyTerminationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionalEarlyTerminationModel> validator() {
		return new OptionalEarlyTerminationModelValidator();
	}

	@Override
	public Validator<? super OptionalEarlyTerminationModel> typeFormatValidator() {
		return new OptionalEarlyTerminationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionalEarlyTerminationModel, Set<String>> onlyExistsValidator() {
		return new OptionalEarlyTerminationModelOnlyExistsValidator();
	}
}
