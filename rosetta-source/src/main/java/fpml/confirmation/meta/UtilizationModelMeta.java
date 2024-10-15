package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UtilizationModel;
import fpml.confirmation.validation.UtilizationModelTypeFormatValidator;
import fpml.confirmation.validation.UtilizationModelValidator;
import fpml.confirmation.validation.exists.UtilizationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UtilizationModel.class)
public class UtilizationModelMeta implements RosettaMetaData<UtilizationModel> {

	@Override
	public List<Validator<? super UtilizationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.UtilizationModel>create(fpml.confirmation.validation.datarule.UtilizationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super UtilizationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UtilizationModel> validator() {
		return new UtilizationModelValidator();
	}

	@Override
	public Validator<? super UtilizationModel> typeFormatValidator() {
		return new UtilizationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UtilizationModel, Set<String>> onlyExistsValidator() {
		return new UtilizationModelOnlyExistsValidator();
	}
}
