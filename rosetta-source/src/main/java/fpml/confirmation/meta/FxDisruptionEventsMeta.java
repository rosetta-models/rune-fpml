package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDisruptionEvents;
import fpml.confirmation.validation.FxDisruptionEventsTypeFormatValidator;
import fpml.confirmation.validation.FxDisruptionEventsValidator;
import fpml.confirmation.validation.exists.FxDisruptionEventsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxDisruptionEvents.class)
public class FxDisruptionEventsMeta implements RosettaMetaData<FxDisruptionEvents> {

	@Override
	public List<Validator<? super FxDisruptionEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDisruptionEvents> validator() {
		return new FxDisruptionEventsValidator();
	}

	@Override
	public Validator<? super FxDisruptionEvents> typeFormatValidator() {
		return new FxDisruptionEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionEvents, Set<String>> onlyExistsValidator() {
		return new FxDisruptionEventsOnlyExistsValidator();
	}
}
