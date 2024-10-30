package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DualCurrencyFeature;
import fpml.confirmation.validation.DualCurrencyFeatureTypeFormatValidator;
import fpml.confirmation.validation.DualCurrencyFeatureValidator;
import fpml.confirmation.validation.exists.DualCurrencyFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DualCurrencyFeature.class)
public class DualCurrencyFeatureMeta implements RosettaMetaData<DualCurrencyFeature> {

	@Override
	public List<Validator<? super DualCurrencyFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DualCurrencyFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DualCurrencyFeature> validator() {
		return new DualCurrencyFeatureValidator();
	}

	@Override
	public Validator<? super DualCurrencyFeature> typeFormatValidator() {
		return new DualCurrencyFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DualCurrencyFeature, Set<String>> onlyExistsValidator() {
		return new DualCurrencyFeatureOnlyExistsValidator();
	}
}
