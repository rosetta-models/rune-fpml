package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1;
import fpml.confirmation.validation.NoTouchUpperBarrierObservationSequence1TypeFormatValidator;
import fpml.confirmation.validation.NoTouchUpperBarrierObservationSequence1Validator;
import fpml.confirmation.validation.exists.NoTouchUpperBarrierObservationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NoTouchUpperBarrierObservationSequence1.class)
public class NoTouchUpperBarrierObservationSequence1Meta implements RosettaMetaData<NoTouchUpperBarrierObservationSequence1> {

	@Override
	public List<Validator<? super NoTouchUpperBarrierObservationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoTouchUpperBarrierObservationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchUpperBarrierObservationSequence1> validator() {
		return new NoTouchUpperBarrierObservationSequence1Validator();
	}

	@Override
	public Validator<? super NoTouchUpperBarrierObservationSequence1> typeFormatValidator() {
		return new NoTouchUpperBarrierObservationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchUpperBarrierObservationSequence1, Set<String>> onlyExistsValidator() {
		return new NoTouchUpperBarrierObservationSequence1OnlyExistsValidator();
	}
}
