package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionBaseFeatureModel;
import fpml.confirmation.validation.OptionBaseFeatureModelTypeFormatValidator;
import fpml.confirmation.validation.OptionBaseFeatureModelValidator;
import fpml.confirmation.validation.exists.OptionBaseFeatureModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionBaseFeatureModel.class)
public class OptionBaseFeatureModelMeta implements RosettaMetaData<OptionBaseFeatureModel> {

	@Override
	public List<Validator<? super OptionBaseFeatureModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionBaseFeatureModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionBaseFeatureModel> validator() {
		return new OptionBaseFeatureModelValidator();
	}

	@Override
	public Validator<? super OptionBaseFeatureModel> typeFormatValidator() {
		return new OptionBaseFeatureModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionBaseFeatureModel, Set<String>> onlyExistsValidator() {
		return new OptionBaseFeatureModelOnlyExistsValidator();
	}
}
