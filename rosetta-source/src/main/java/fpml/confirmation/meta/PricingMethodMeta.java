package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingMethod;
import fpml.confirmation.validation.PricingMethodTypeFormatValidator;
import fpml.confirmation.validation.PricingMethodValidator;
import fpml.confirmation.validation.exists.PricingMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PricingMethod.class)
public class PricingMethodMeta implements RosettaMetaData<PricingMethod> {

	@Override
	public List<Validator<? super PricingMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingMethod> validator() {
		return new PricingMethodValidator();
	}

	@Override
	public Validator<? super PricingMethod> typeFormatValidator() {
		return new PricingMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingMethod, Set<String>> onlyExistsValidator() {
		return new PricingMethodOnlyExistsValidator();
	}
}
