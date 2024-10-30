package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateAccrualSequence;
import fpml.confirmation.validation.FloatingRateAccrualSequenceTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateAccrualSequenceValidator;
import fpml.confirmation.validation.exists.FloatingRateAccrualSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingRateAccrualSequence.class)
public class FloatingRateAccrualSequenceMeta implements RosettaMetaData<FloatingRateAccrualSequence> {

	@Override
	public List<Validator<? super FloatingRateAccrualSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateAccrualSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateAccrualSequence> validator() {
		return new FloatingRateAccrualSequenceValidator();
	}

	@Override
	public Validator<? super FloatingRateAccrualSequence> typeFormatValidator() {
		return new FloatingRateAccrualSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateAccrualSequence, Set<String>> onlyExistsValidator() {
		return new FloatingRateAccrualSequenceOnlyExistsValidator();
	}
}
