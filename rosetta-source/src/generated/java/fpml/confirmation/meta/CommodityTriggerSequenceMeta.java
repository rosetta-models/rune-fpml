package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityTriggerSequence;
import fpml.confirmation.validation.CommodityTriggerSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityTriggerSequenceValidator;
import fpml.confirmation.validation.exists.CommodityTriggerSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityTriggerSequence.class)
public class CommodityTriggerSequenceMeta implements RosettaMetaData<CommodityTriggerSequence> {

	@Override
	public List<Validator<? super CommodityTriggerSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityTriggerSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityTriggerSequence> validator() {
		return new CommodityTriggerSequenceValidator();
	}

	@Override
	public Validator<? super CommodityTriggerSequence> typeFormatValidator() {
		return new CommodityTriggerSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityTriggerSequence, Set<String>> onlyExistsValidator() {
		return new CommodityTriggerSequenceOnlyExistsValidator();
	}
}
