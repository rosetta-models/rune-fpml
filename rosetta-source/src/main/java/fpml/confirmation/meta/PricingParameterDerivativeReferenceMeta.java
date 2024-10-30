package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingParameterDerivativeReference;
import fpml.confirmation.validation.PricingParameterDerivativeReferenceTypeFormatValidator;
import fpml.confirmation.validation.PricingParameterDerivativeReferenceValidator;
import fpml.confirmation.validation.exists.PricingParameterDerivativeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PricingParameterDerivativeReference.class)
public class PricingParameterDerivativeReferenceMeta implements RosettaMetaData<PricingParameterDerivativeReference> {

	@Override
	public List<Validator<? super PricingParameterDerivativeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingParameterDerivativeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingParameterDerivativeReference> validator() {
		return new PricingParameterDerivativeReferenceValidator();
	}

	@Override
	public Validator<? super PricingParameterDerivativeReference> typeFormatValidator() {
		return new PricingParameterDerivativeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingParameterDerivativeReference, Set<String>> onlyExistsValidator() {
		return new PricingParameterDerivativeReferenceOnlyExistsValidator();
	}
}
