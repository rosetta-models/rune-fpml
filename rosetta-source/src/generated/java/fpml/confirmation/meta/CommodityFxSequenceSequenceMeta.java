package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFxSequenceSequence;
import fpml.confirmation.validation.CommodityFxSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityFxSequenceSequenceValidator;
import fpml.confirmation.validation.exists.CommodityFxSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityFxSequenceSequence.class)
public class CommodityFxSequenceSequenceMeta implements RosettaMetaData<CommodityFxSequenceSequence> {

	@Override
	public List<Validator<? super CommodityFxSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFxSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFxSequenceSequence> validator() {
		return new CommodityFxSequenceSequenceValidator();
	}

	@Override
	public Validator<? super CommodityFxSequenceSequence> typeFormatValidator() {
		return new CommodityFxSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFxSequenceSequence, Set<String>> onlyExistsValidator() {
		return new CommodityFxSequenceSequenceOnlyExistsValidator();
	}
}
