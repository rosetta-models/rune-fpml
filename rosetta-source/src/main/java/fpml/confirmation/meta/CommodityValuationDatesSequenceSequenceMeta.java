package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityValuationDatesSequenceSequence;
import fpml.confirmation.validation.CommodityValuationDatesSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityValuationDatesSequenceSequenceValidator;
import fpml.confirmation.validation.exists.CommodityValuationDatesSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityValuationDatesSequenceSequence.class)
public class CommodityValuationDatesSequenceSequenceMeta implements RosettaMetaData<CommodityValuationDatesSequenceSequence> {

	@Override
	public List<Validator<? super CommodityValuationDatesSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityValuationDatesSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityValuationDatesSequenceSequence> validator() {
		return new CommodityValuationDatesSequenceSequenceValidator();
	}

	@Override
	public Validator<? super CommodityValuationDatesSequenceSequence> typeFormatValidator() {
		return new CommodityValuationDatesSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityValuationDatesSequenceSequence, Set<String>> onlyExistsValidator() {
		return new CommodityValuationDatesSequenceSequenceOnlyExistsValidator();
	}
}
