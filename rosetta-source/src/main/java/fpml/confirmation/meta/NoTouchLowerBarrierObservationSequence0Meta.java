package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0;
import fpml.confirmation.validation.NoTouchLowerBarrierObservationSequence0TypeFormatValidator;
import fpml.confirmation.validation.NoTouchLowerBarrierObservationSequence0Validator;
import fpml.confirmation.validation.exists.NoTouchLowerBarrierObservationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NoTouchLowerBarrierObservationSequence0.class)
public class NoTouchLowerBarrierObservationSequence0Meta implements RosettaMetaData<NoTouchLowerBarrierObservationSequence0> {

	@Override
	public List<Validator<? super NoTouchLowerBarrierObservationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoTouchLowerBarrierObservationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservationSequence0> validator() {
		return new NoTouchLowerBarrierObservationSequence0Validator();
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservationSequence0> typeFormatValidator() {
		return new NoTouchLowerBarrierObservationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchLowerBarrierObservationSequence0, Set<String>> onlyExistsValidator() {
		return new NoTouchLowerBarrierObservationSequence0OnlyExistsValidator();
	}
}
