package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingContext;
import fpml.confirmation.validation.PricingContextTypeFormatValidator;
import fpml.confirmation.validation.PricingContextValidator;
import fpml.confirmation.validation.exists.PricingContextOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PricingContext.class)
public class PricingContextMeta implements RosettaMetaData<PricingContext> {

	@Override
	public List<Validator<? super PricingContext>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingContext, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingContext> validator() {
		return new PricingContextValidator();
	}

	@Override
	public Validator<? super PricingContext> typeFormatValidator() {
		return new PricingContextTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingContext, Set<String>> onlyExistsValidator() {
		return new PricingContextOnlyExistsValidator();
	}
}
