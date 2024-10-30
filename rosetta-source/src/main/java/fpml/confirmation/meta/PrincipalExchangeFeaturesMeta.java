package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.validation.PrincipalExchangeFeaturesTypeFormatValidator;
import fpml.confirmation.validation.PrincipalExchangeFeaturesValidator;
import fpml.confirmation.validation.exists.PrincipalExchangeFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PrincipalExchangeFeatures.class)
public class PrincipalExchangeFeaturesMeta implements RosettaMetaData<PrincipalExchangeFeatures> {

	@Override
	public List<Validator<? super PrincipalExchangeFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchangeFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrincipalExchangeFeatures> validator() {
		return new PrincipalExchangeFeaturesValidator();
	}

	@Override
	public Validator<? super PrincipalExchangeFeatures> typeFormatValidator() {
		return new PrincipalExchangeFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchangeFeatures, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeFeaturesOnlyExistsValidator();
	}
}
