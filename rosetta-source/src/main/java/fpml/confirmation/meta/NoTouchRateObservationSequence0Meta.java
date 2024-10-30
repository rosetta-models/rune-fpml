package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchRateObservationSequence0;
import fpml.confirmation.validation.NoTouchRateObservationSequence0TypeFormatValidator;
import fpml.confirmation.validation.NoTouchRateObservationSequence0Validator;
import fpml.confirmation.validation.exists.NoTouchRateObservationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NoTouchRateObservationSequence0.class)
public class NoTouchRateObservationSequence0Meta implements RosettaMetaData<NoTouchRateObservationSequence0> {

	@Override
	public List<Validator<? super NoTouchRateObservationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoTouchRateObservationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchRateObservationSequence0> validator() {
		return new NoTouchRateObservationSequence0Validator();
	}

	@Override
	public Validator<? super NoTouchRateObservationSequence0> typeFormatValidator() {
		return new NoTouchRateObservationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchRateObservationSequence0, Set<String>> onlyExistsValidator() {
		return new NoTouchRateObservationSequence0OnlyExistsValidator();
	}
}
