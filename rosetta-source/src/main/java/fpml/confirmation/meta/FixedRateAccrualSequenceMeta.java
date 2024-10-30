package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateAccrualSequence;
import fpml.confirmation.validation.FixedRateAccrualSequenceTypeFormatValidator;
import fpml.confirmation.validation.FixedRateAccrualSequenceValidator;
import fpml.confirmation.validation.exists.FixedRateAccrualSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedRateAccrualSequence.class)
public class FixedRateAccrualSequenceMeta implements RosettaMetaData<FixedRateAccrualSequence> {

	@Override
	public List<Validator<? super FixedRateAccrualSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateAccrualSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRateAccrualSequence> validator() {
		return new FixedRateAccrualSequenceValidator();
	}

	@Override
	public Validator<? super FixedRateAccrualSequence> typeFormatValidator() {
		return new FixedRateAccrualSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateAccrualSequence, Set<String>> onlyExistsValidator() {
		return new FixedRateAccrualSequenceOnlyExistsValidator();
	}
}
