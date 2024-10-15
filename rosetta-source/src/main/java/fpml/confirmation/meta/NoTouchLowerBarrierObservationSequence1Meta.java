package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1;
import fpml.confirmation.validation.NoTouchLowerBarrierObservationSequence1TypeFormatValidator;
import fpml.confirmation.validation.NoTouchLowerBarrierObservationSequence1Validator;
import fpml.confirmation.validation.exists.NoTouchLowerBarrierObservationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NoTouchLowerBarrierObservationSequence1.class)
public class NoTouchLowerBarrierObservationSequence1Meta implements RosettaMetaData<NoTouchLowerBarrierObservationSequence1> {

	@Override
	public List<Validator<? super NoTouchLowerBarrierObservationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoTouchLowerBarrierObservationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservationSequence1> validator() {
		return new NoTouchLowerBarrierObservationSequence1Validator();
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservationSequence1> typeFormatValidator() {
		return new NoTouchLowerBarrierObservationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchLowerBarrierObservationSequence1, Set<String>> onlyExistsValidator() {
		return new NoTouchLowerBarrierObservationSequence1OnlyExistsValidator();
	}
}
