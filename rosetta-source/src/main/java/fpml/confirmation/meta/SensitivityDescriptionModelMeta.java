package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SensitivityDescriptionModel;
import fpml.confirmation.validation.SensitivityDescriptionModelTypeFormatValidator;
import fpml.confirmation.validation.SensitivityDescriptionModelValidator;
import fpml.confirmation.validation.exists.SensitivityDescriptionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SensitivityDescriptionModel.class)
public class SensitivityDescriptionModelMeta implements RosettaMetaData<SensitivityDescriptionModel> {

	@Override
	public List<Validator<? super SensitivityDescriptionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SensitivityDescriptionModel>create(fpml.confirmation.validation.datarule.SensitivityDescriptionModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SensitivityDescriptionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SensitivityDescriptionModel> validator() {
		return new SensitivityDescriptionModelValidator();
	}

	@Override
	public Validator<? super SensitivityDescriptionModel> typeFormatValidator() {
		return new SensitivityDescriptionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityDescriptionModel, Set<String>> onlyExistsValidator() {
		return new SensitivityDescriptionModelOnlyExistsValidator();
	}
}
