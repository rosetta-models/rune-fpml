package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFallbackReferencePrice;
import fpml.confirmation.validation.FxFallbackReferencePriceTypeFormatValidator;
import fpml.confirmation.validation.FxFallbackReferencePriceValidator;
import fpml.confirmation.validation.exists.FxFallbackReferencePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxFallbackReferencePrice.class)
public class FxFallbackReferencePriceMeta implements RosettaMetaData<FxFallbackReferencePrice> {

	@Override
	public List<Validator<? super FxFallbackReferencePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFallbackReferencePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFallbackReferencePrice> validator() {
		return new FxFallbackReferencePriceValidator();
	}

	@Override
	public Validator<? super FxFallbackReferencePrice> typeFormatValidator() {
		return new FxFallbackReferencePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFallbackReferencePrice, Set<String>> onlyExistsValidator() {
		return new FxFallbackReferencePriceOnlyExistsValidator();
	}
}
