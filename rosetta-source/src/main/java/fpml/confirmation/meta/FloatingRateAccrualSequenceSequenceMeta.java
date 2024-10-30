package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateAccrualSequenceSequence;
import fpml.confirmation.validation.FloatingRateAccrualSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateAccrualSequenceSequenceValidator;
import fpml.confirmation.validation.exists.FloatingRateAccrualSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingRateAccrualSequenceSequence.class)
public class FloatingRateAccrualSequenceSequenceMeta implements RosettaMetaData<FloatingRateAccrualSequenceSequence> {

	@Override
	public List<Validator<? super FloatingRateAccrualSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateAccrualSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateAccrualSequenceSequence> validator() {
		return new FloatingRateAccrualSequenceSequenceValidator();
	}

	@Override
	public Validator<? super FloatingRateAccrualSequenceSequence> typeFormatValidator() {
		return new FloatingRateAccrualSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateAccrualSequenceSequence, Set<String>> onlyExistsValidator() {
		return new FloatingRateAccrualSequenceSequenceOnlyExistsValidator();
	}
}
