package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.validation.FxOptionFeaturesTypeFormatValidator;
import fpml.confirmation.validation.FxOptionFeaturesValidator;
import fpml.confirmation.validation.exists.FxOptionFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxOptionFeatures.class)
public class FxOptionFeaturesMeta implements RosettaMetaData<FxOptionFeatures> {

	@Override
	public List<Validator<? super FxOptionFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxOptionFeatures>create(fpml.confirmation.validation.datarule.FxOptionFeaturesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxOptionFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOptionFeatures> validator() {
		return new FxOptionFeaturesValidator();
	}

	@Override
	public Validator<? super FxOptionFeatures> typeFormatValidator() {
		return new FxOptionFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionFeatures, Set<String>> onlyExistsValidator() {
		return new FxOptionFeaturesOnlyExistsValidator();
	}
}
