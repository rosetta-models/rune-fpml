package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.validation.CommodityNotionalAmountReferenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityNotionalAmountReferenceValidator;
import fpml.confirmation.validation.exists.CommodityNotionalAmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityNotionalAmountReference.class)
public class CommodityNotionalAmountReferenceMeta implements RosettaMetaData<CommodityNotionalAmountReference> {

	@Override
	public List<Validator<? super CommodityNotionalAmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalAmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNotionalAmountReference> validator() {
		return new CommodityNotionalAmountReferenceValidator();
	}

	@Override
	public Validator<? super CommodityNotionalAmountReference> typeFormatValidator() {
		return new CommodityNotionalAmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalAmountReference, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalAmountReferenceOnlyExistsValidator();
	}
}
