package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KnockOutRateObservation;
import fpml.confirmation.validation.KnockOutRateObservationTypeFormatValidator;
import fpml.confirmation.validation.KnockOutRateObservationValidator;
import fpml.confirmation.validation.exists.KnockOutRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=KnockOutRateObservation.class)
public class KnockOutRateObservationMeta implements RosettaMetaData<KnockOutRateObservation> {

	@Override
	public List<Validator<? super KnockOutRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TriggerRateObservation>create(fpml.confirmation.validation.datarule.TriggerRateObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KnockOutRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super KnockOutRateObservation> validator() {
		return new KnockOutRateObservationValidator();
	}

	@Override
	public Validator<? super KnockOutRateObservation> typeFormatValidator() {
		return new KnockOutRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KnockOutRateObservation, Set<String>> onlyExistsValidator() {
		return new KnockOutRateObservationOnlyExistsValidator();
	}
}
