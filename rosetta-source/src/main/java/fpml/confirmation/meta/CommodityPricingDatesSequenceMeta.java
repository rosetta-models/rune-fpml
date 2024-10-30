package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPricingDatesSequence;
import fpml.confirmation.validation.CommodityPricingDatesSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityPricingDatesSequenceValidator;
import fpml.confirmation.validation.exists.CommodityPricingDatesSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPricingDatesSequence.class)
public class CommodityPricingDatesSequenceMeta implements RosettaMetaData<CommodityPricingDatesSequence> {

	@Override
	public List<Validator<? super CommodityPricingDatesSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPricingDatesSequence>create(fpml.confirmation.validation.datarule.CommodityPricingDatesSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPricingDatesSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPricingDatesSequence> validator() {
		return new CommodityPricingDatesSequenceValidator();
	}

	@Override
	public Validator<? super CommodityPricingDatesSequence> typeFormatValidator() {
		return new CommodityPricingDatesSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPricingDatesSequence, Set<String>> onlyExistsValidator() {
		return new CommodityPricingDatesSequenceOnlyExistsValidator();
	}
}
