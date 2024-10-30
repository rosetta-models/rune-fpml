package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFxSequenceSequenceSequence;
import fpml.confirmation.validation.CommodityFxSequenceSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityFxSequenceSequenceSequenceValidator;
import fpml.confirmation.validation.exists.CommodityFxSequenceSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFxSequenceSequenceSequence.class)
public class CommodityFxSequenceSequenceSequenceMeta implements RosettaMetaData<CommodityFxSequenceSequenceSequence> {

	@Override
	public List<Validator<? super CommodityFxSequenceSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFxSequenceSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFxSequenceSequenceSequence> validator() {
		return new CommodityFxSequenceSequenceSequenceValidator();
	}

	@Override
	public Validator<? super CommodityFxSequenceSequenceSequence> typeFormatValidator() {
		return new CommodityFxSequenceSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFxSequenceSequenceSequence, Set<String>> onlyExistsValidator() {
		return new CommodityFxSequenceSequenceSequenceOnlyExistsValidator();
	}
}
