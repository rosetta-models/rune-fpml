package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.validation.PricingStructureReferenceTypeFormatValidator;
import fpml.confirmation.validation.PricingStructureReferenceValidator;
import fpml.confirmation.validation.exists.PricingStructureReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PricingStructureReference.class)
public class PricingStructureReferenceMeta implements RosettaMetaData<PricingStructureReference> {

	@Override
	public List<Validator<? super PricingStructureReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingStructureReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingStructureReference> validator() {
		return new PricingStructureReferenceValidator();
	}

	@Override
	public Validator<? super PricingStructureReference> typeFormatValidator() {
		return new PricingStructureReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructureReference, Set<String>> onlyExistsValidator() {
		return new PricingStructureReferenceOnlyExistsValidator();
	}
}
