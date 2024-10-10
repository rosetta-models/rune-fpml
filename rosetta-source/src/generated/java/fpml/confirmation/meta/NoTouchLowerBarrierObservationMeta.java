package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchLowerBarrierObservation;
import fpml.confirmation.validation.NoTouchLowerBarrierObservationTypeFormatValidator;
import fpml.confirmation.validation.NoTouchLowerBarrierObservationValidator;
import fpml.confirmation.validation.exists.NoTouchLowerBarrierObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NoTouchLowerBarrierObservation.class)
public class NoTouchLowerBarrierObservationMeta implements RosettaMetaData<NoTouchLowerBarrierObservation> {

	@Override
	public List<Validator<? super NoTouchLowerBarrierObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NoTouchLowerBarrierObservation>create(fpml.confirmation.validation.datarule.NoTouchLowerBarrierObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NoTouchLowerBarrierObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservation> validator() {
		return new NoTouchLowerBarrierObservationValidator();
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservation> typeFormatValidator() {
		return new NoTouchLowerBarrierObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchLowerBarrierObservation, Set<String>> onlyExistsValidator() {
		return new NoTouchLowerBarrierObservationOnlyExistsValidator();
	}
}
