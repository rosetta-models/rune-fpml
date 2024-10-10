package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0;
import fpml.confirmation.validation.NoTouchUpperBarrierObservationSequence0TypeFormatValidator;
import fpml.confirmation.validation.NoTouchUpperBarrierObservationSequence0Validator;
import fpml.confirmation.validation.exists.NoTouchUpperBarrierObservationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NoTouchUpperBarrierObservationSequence0.class)
public class NoTouchUpperBarrierObservationSequence0Meta implements RosettaMetaData<NoTouchUpperBarrierObservationSequence0> {

	@Override
	public List<Validator<? super NoTouchUpperBarrierObservationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoTouchUpperBarrierObservationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchUpperBarrierObservationSequence0> validator() {
		return new NoTouchUpperBarrierObservationSequence0Validator();
	}

	@Override
	public Validator<? super NoTouchUpperBarrierObservationSequence0> typeFormatValidator() {
		return new NoTouchUpperBarrierObservationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchUpperBarrierObservationSequence0, Set<String>> onlyExistsValidator() {
		return new NoTouchUpperBarrierObservationSequence0OnlyExistsValidator();
	}
}
