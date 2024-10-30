package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetOrTermPointOrPricingStructureReference;
import fpml.confirmation.validation.AssetOrTermPointOrPricingStructureReferenceTypeFormatValidator;
import fpml.confirmation.validation.AssetOrTermPointOrPricingStructureReferenceValidator;
import fpml.confirmation.validation.exists.AssetOrTermPointOrPricingStructureReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AssetOrTermPointOrPricingStructureReference.class)
public class AssetOrTermPointOrPricingStructureReferenceMeta implements RosettaMetaData<AssetOrTermPointOrPricingStructureReference> {

	@Override
	public List<Validator<? super AssetOrTermPointOrPricingStructureReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetOrTermPointOrPricingStructureReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetOrTermPointOrPricingStructureReference> validator() {
		return new AssetOrTermPointOrPricingStructureReferenceValidator();
	}

	@Override
	public Validator<? super AssetOrTermPointOrPricingStructureReference> typeFormatValidator() {
		return new AssetOrTermPointOrPricingStructureReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetOrTermPointOrPricingStructureReference, Set<String>> onlyExistsValidator() {
		return new AssetOrTermPointOrPricingStructureReferenceOnlyExistsValidator();
	}
}
