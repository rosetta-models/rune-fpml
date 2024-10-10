package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.validation.NoTouchRateObservationTypeFormatValidator;
import fpml.confirmation.validation.NoTouchRateObservationValidator;
import fpml.confirmation.validation.exists.NoTouchRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NoTouchRateObservation.class)
public class NoTouchRateObservationMeta implements RosettaMetaData<NoTouchRateObservation> {

	@Override
	public List<Validator<? super NoTouchRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NoTouchRateObservation>create(fpml.confirmation.validation.datarule.NoTouchRateObservationChoice0.class),
			factory.<fpml.confirmation.NoTouchRateObservation>create(fpml.confirmation.validation.datarule.NoTouchRateObservationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super NoTouchRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchRateObservation> validator() {
		return new NoTouchRateObservationValidator();
	}

	@Override
	public Validator<? super NoTouchRateObservation> typeFormatValidator() {
		return new NoTouchRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchRateObservation, Set<String>> onlyExistsValidator() {
		return new NoTouchRateObservationOnlyExistsValidator();
	}
}
