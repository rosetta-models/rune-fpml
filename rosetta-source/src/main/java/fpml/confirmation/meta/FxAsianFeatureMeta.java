package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAsianFeature;
import fpml.confirmation.validation.FxAsianFeatureTypeFormatValidator;
import fpml.confirmation.validation.FxAsianFeatureValidator;
import fpml.confirmation.validation.exists.FxAsianFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAsianFeature.class)
public class FxAsianFeatureMeta implements RosettaMetaData<FxAsianFeature> {

	@Override
	public List<Validator<? super FxAsianFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAsianFeature>create(fpml.confirmation.validation.datarule.FxAsianFeatureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAsianFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAsianFeature> validator() {
		return new FxAsianFeatureValidator();
	}

	@Override
	public Validator<? super FxAsianFeature> typeFormatValidator() {
		return new FxAsianFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAsianFeature, Set<String>> onlyExistsValidator() {
		return new FxAsianFeatureOnlyExistsValidator();
	}
}
