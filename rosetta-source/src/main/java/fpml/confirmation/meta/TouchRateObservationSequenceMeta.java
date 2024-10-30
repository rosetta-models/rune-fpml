package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TouchRateObservationSequence;
import fpml.confirmation.validation.TouchRateObservationSequenceTypeFormatValidator;
import fpml.confirmation.validation.TouchRateObservationSequenceValidator;
import fpml.confirmation.validation.exists.TouchRateObservationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TouchRateObservationSequence.class)
public class TouchRateObservationSequenceMeta implements RosettaMetaData<TouchRateObservationSequence> {

	@Override
	public List<Validator<? super TouchRateObservationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TouchRateObservationSequence>create(fpml.confirmation.validation.datarule.TouchRateObservationSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TouchRateObservationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TouchRateObservationSequence> validator() {
		return new TouchRateObservationSequenceValidator();
	}

	@Override
	public Validator<? super TouchRateObservationSequence> typeFormatValidator() {
		return new TouchRateObservationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TouchRateObservationSequence, Set<String>> onlyExistsValidator() {
		return new TouchRateObservationSequenceOnlyExistsValidator();
	}
}
