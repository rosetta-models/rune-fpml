package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingObservation;
import fpml.confirmation.validation.FxFixingObservationTypeFormatValidator;
import fpml.confirmation.validation.FxFixingObservationValidator;
import fpml.confirmation.validation.exists.FxFixingObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxFixingObservation.class)
public class FxFixingObservationMeta implements RosettaMetaData<FxFixingObservation> {

	@Override
	public List<Validator<? super FxFixingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFixingObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingObservation> validator() {
		return new FxFixingObservationValidator();
	}

	@Override
	public Validator<? super FxFixingObservation> typeFormatValidator() {
		return new FxFixingObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingObservation, Set<String>> onlyExistsValidator() {
		return new FxFixingObservationOnlyExistsValidator();
	}
}
