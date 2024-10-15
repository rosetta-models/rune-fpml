package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionFeatures;
import fpml.confirmation.validation.OptionFeaturesTypeFormatValidator;
import fpml.confirmation.validation.OptionFeaturesValidator;
import fpml.confirmation.validation.exists.OptionFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionFeatures.class)
public class OptionFeaturesMeta implements RosettaMetaData<OptionFeatures> {

	@Override
	public List<Validator<? super OptionFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionFeatures> validator() {
		return new OptionFeaturesValidator();
	}

	@Override
	public Validator<? super OptionFeatures> typeFormatValidator() {
		return new OptionFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionFeatures, Set<String>> onlyExistsValidator() {
		return new OptionFeaturesOnlyExistsValidator();
	}
}
