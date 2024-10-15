package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.validation.FeatureModelTypeFormatValidator;
import fpml.confirmation.validation.FeatureModelValidator;
import fpml.confirmation.validation.exists.FeatureModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FeatureModel.class)
public class FeatureModelMeta implements RosettaMetaData<FeatureModel> {

	@Override
	public List<Validator<? super FeatureModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FeatureModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeatureModel> validator() {
		return new FeatureModelValidator();
	}

	@Override
	public Validator<? super FeatureModel> typeFormatValidator() {
		return new FeatureModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeatureModel, Set<String>> onlyExistsValidator() {
		return new FeatureModelOnlyExistsValidator();
	}
}
