package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityValuationDatesSequence;
import fpml.confirmation.validation.CommodityValuationDatesSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityValuationDatesSequenceValidator;
import fpml.confirmation.validation.exists.CommodityValuationDatesSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityValuationDatesSequence.class)
public class CommodityValuationDatesSequenceMeta implements RosettaMetaData<CommodityValuationDatesSequence> {

	@Override
	public List<Validator<? super CommodityValuationDatesSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityValuationDatesSequence>create(fpml.confirmation.validation.datarule.CommodityValuationDatesSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityValuationDatesSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityValuationDatesSequence> validator() {
		return new CommodityValuationDatesSequenceValidator();
	}

	@Override
	public Validator<? super CommodityValuationDatesSequence> typeFormatValidator() {
		return new CommodityValuationDatesSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityValuationDatesSequence, Set<String>> onlyExistsValidator() {
		return new CommodityValuationDatesSequenceOnlyExistsValidator();
	}
}
