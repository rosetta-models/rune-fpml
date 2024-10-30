package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFxSequence;
import fpml.confirmation.validation.CommodityFxSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityFxSequenceValidator;
import fpml.confirmation.validation.exists.CommodityFxSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFxSequence.class)
public class CommodityFxSequenceMeta implements RosettaMetaData<CommodityFxSequence> {

	@Override
	public List<Validator<? super CommodityFxSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFxSequence>create(fpml.confirmation.validation.datarule.CommodityFxSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFxSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFxSequence> validator() {
		return new CommodityFxSequenceValidator();
	}

	@Override
	public Validator<? super CommodityFxSequence> typeFormatValidator() {
		return new CommodityFxSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFxSequence, Set<String>> onlyExistsValidator() {
		return new CommodityFxSequenceOnlyExistsValidator();
	}
}
