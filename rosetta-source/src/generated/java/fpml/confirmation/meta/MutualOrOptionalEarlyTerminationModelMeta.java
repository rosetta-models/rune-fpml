package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel;
import fpml.confirmation.validation.MutualOrOptionalEarlyTerminationModelTypeFormatValidator;
import fpml.confirmation.validation.MutualOrOptionalEarlyTerminationModelValidator;
import fpml.confirmation.validation.exists.MutualOrOptionalEarlyTerminationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MutualOrOptionalEarlyTerminationModel.class)
public class MutualOrOptionalEarlyTerminationModelMeta implements RosettaMetaData<MutualOrOptionalEarlyTerminationModel> {

	@Override
	public List<Validator<? super MutualOrOptionalEarlyTerminationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.MutualOrOptionalEarlyTerminationModel>create(fpml.confirmation.validation.datarule.MutualOrOptionalEarlyTerminationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MutualOrOptionalEarlyTerminationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MutualOrOptionalEarlyTerminationModel> validator() {
		return new MutualOrOptionalEarlyTerminationModelValidator();
	}

	@Override
	public Validator<? super MutualOrOptionalEarlyTerminationModel> typeFormatValidator() {
		return new MutualOrOptionalEarlyTerminationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MutualOrOptionalEarlyTerminationModel, Set<String>> onlyExistsValidator() {
		return new MutualOrOptionalEarlyTerminationModelOnlyExistsValidator();
	}
}
