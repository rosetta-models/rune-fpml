package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingParameterDerivative;
import fpml.confirmation.validation.PricingParameterDerivativeTypeFormatValidator;
import fpml.confirmation.validation.PricingParameterDerivativeValidator;
import fpml.confirmation.validation.exists.PricingParameterDerivativeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PricingParameterDerivative.class)
public class PricingParameterDerivativeMeta implements RosettaMetaData<PricingParameterDerivative> {

	@Override
	public List<Validator<? super PricingParameterDerivative>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PricingParameterDerivative>create(fpml.confirmation.validation.datarule.PricingParameterDerivativeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingParameterDerivative, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingParameterDerivative> validator() {
		return new PricingParameterDerivativeValidator();
	}

	@Override
	public Validator<? super PricingParameterDerivative> typeFormatValidator() {
		return new PricingParameterDerivativeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingParameterDerivative, Set<String>> onlyExistsValidator() {
		return new PricingParameterDerivativeOnlyExistsValidator();
	}
}
