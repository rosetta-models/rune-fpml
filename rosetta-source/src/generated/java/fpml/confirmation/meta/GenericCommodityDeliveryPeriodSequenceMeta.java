package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence;
import fpml.confirmation.validation.GenericCommodityDeliveryPeriodSequenceTypeFormatValidator;
import fpml.confirmation.validation.GenericCommodityDeliveryPeriodSequenceValidator;
import fpml.confirmation.validation.exists.GenericCommodityDeliveryPeriodSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericCommodityDeliveryPeriodSequence.class)
public class GenericCommodityDeliveryPeriodSequenceMeta implements RosettaMetaData<GenericCommodityDeliveryPeriodSequence> {

	@Override
	public List<Validator<? super GenericCommodityDeliveryPeriodSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericCommodityDeliveryPeriodSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericCommodityDeliveryPeriodSequence> validator() {
		return new GenericCommodityDeliveryPeriodSequenceValidator();
	}

	@Override
	public Validator<? super GenericCommodityDeliveryPeriodSequence> typeFormatValidator() {
		return new GenericCommodityDeliveryPeriodSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericCommodityDeliveryPeriodSequence, Set<String>> onlyExistsValidator() {
		return new GenericCommodityDeliveryPeriodSequenceOnlyExistsValidator();
	}
}
