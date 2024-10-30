package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPricingDatesSequenceSequence;
import fpml.confirmation.validation.CommodityPricingDatesSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityPricingDatesSequenceSequenceValidator;
import fpml.confirmation.validation.exists.CommodityPricingDatesSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPricingDatesSequenceSequence.class)
public class CommodityPricingDatesSequenceSequenceMeta implements RosettaMetaData<CommodityPricingDatesSequenceSequence> {

	@Override
	public List<Validator<? super CommodityPricingDatesSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPricingDatesSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPricingDatesSequenceSequence> validator() {
		return new CommodityPricingDatesSequenceSequenceValidator();
	}

	@Override
	public Validator<? super CommodityPricingDatesSequenceSequence> typeFormatValidator() {
		return new CommodityPricingDatesSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPricingDatesSequenceSequence, Set<String>> onlyExistsValidator() {
		return new CommodityPricingDatesSequenceSequenceOnlyExistsValidator();
	}
}
