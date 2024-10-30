package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchRateObservationSequence1;
import fpml.confirmation.validation.NoTouchRateObservationSequence1TypeFormatValidator;
import fpml.confirmation.validation.NoTouchRateObservationSequence1Validator;
import fpml.confirmation.validation.exists.NoTouchRateObservationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NoTouchRateObservationSequence1.class)
public class NoTouchRateObservationSequence1Meta implements RosettaMetaData<NoTouchRateObservationSequence1> {

	@Override
	public List<Validator<? super NoTouchRateObservationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NoTouchRateObservationSequence1>create(fpml.confirmation.validation.datarule.NoTouchRateObservationSequence1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super NoTouchRateObservationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoTouchRateObservationSequence1> validator() {
		return new NoTouchRateObservationSequence1Validator();
	}

	@Override
	public Validator<? super NoTouchRateObservationSequence1> typeFormatValidator() {
		return new NoTouchRateObservationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchRateObservationSequence1, Set<String>> onlyExistsValidator() {
		return new NoTouchRateObservationSequence1OnlyExistsValidator();
	}
}
