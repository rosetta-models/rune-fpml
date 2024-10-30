package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MandatoryEarlyTerminationModel;
import fpml.confirmation.validation.MandatoryEarlyTerminationModelTypeFormatValidator;
import fpml.confirmation.validation.MandatoryEarlyTerminationModelValidator;
import fpml.confirmation.validation.exists.MandatoryEarlyTerminationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MandatoryEarlyTerminationModel.class)
public class MandatoryEarlyTerminationModelMeta implements RosettaMetaData<MandatoryEarlyTerminationModel> {

	@Override
	public List<Validator<? super MandatoryEarlyTerminationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.MandatoryEarlyTerminationModel>create(fpml.confirmation.validation.datarule.MandatoryEarlyTerminationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MandatoryEarlyTerminationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MandatoryEarlyTerminationModel> validator() {
		return new MandatoryEarlyTerminationModelValidator();
	}

	@Override
	public Validator<? super MandatoryEarlyTerminationModel> typeFormatValidator() {
		return new MandatoryEarlyTerminationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryEarlyTerminationModel, Set<String>> onlyExistsValidator() {
		return new MandatoryEarlyTerminationModelOnlyExistsValidator();
	}
}
