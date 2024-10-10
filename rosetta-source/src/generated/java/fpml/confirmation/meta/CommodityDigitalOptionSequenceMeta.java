package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDigitalOptionSequence;
import fpml.confirmation.validation.CommodityDigitalOptionSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityDigitalOptionSequenceValidator;
import fpml.confirmation.validation.exists.CommodityDigitalOptionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDigitalOptionSequence.class)
public class CommodityDigitalOptionSequenceMeta implements RosettaMetaData<CommodityDigitalOptionSequence> {

	@Override
	public List<Validator<? super CommodityDigitalOptionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDigitalOptionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDigitalOptionSequence> validator() {
		return new CommodityDigitalOptionSequenceValidator();
	}

	@Override
	public Validator<? super CommodityDigitalOptionSequence> typeFormatValidator() {
		return new CommodityDigitalOptionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigitalOptionSequence, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalOptionSequenceOnlyExistsValidator();
	}
}
