package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDeliveryPeriodsSequence;
import fpml.confirmation.validation.GasDeliveryPeriodsSequenceTypeFormatValidator;
import fpml.confirmation.validation.GasDeliveryPeriodsSequenceValidator;
import fpml.confirmation.validation.exists.GasDeliveryPeriodsSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GasDeliveryPeriodsSequence.class)
public class GasDeliveryPeriodsSequenceMeta implements RosettaMetaData<GasDeliveryPeriodsSequence> {

	@Override
	public List<Validator<? super GasDeliveryPeriodsSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasDeliveryPeriodsSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasDeliveryPeriodsSequence> validator() {
		return new GasDeliveryPeriodsSequenceValidator();
	}

	@Override
	public Validator<? super GasDeliveryPeriodsSequence> typeFormatValidator() {
		return new GasDeliveryPeriodsSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDeliveryPeriodsSequence, Set<String>> onlyExistsValidator() {
		return new GasDeliveryPeriodsSequenceOnlyExistsValidator();
	}
}
