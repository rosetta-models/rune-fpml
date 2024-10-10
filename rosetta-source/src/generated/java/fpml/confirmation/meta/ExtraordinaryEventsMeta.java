package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.validation.ExtraordinaryEventsTypeFormatValidator;
import fpml.confirmation.validation.ExtraordinaryEventsValidator;
import fpml.confirmation.validation.exists.ExtraordinaryEventsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExtraordinaryEvents.class)
public class ExtraordinaryEventsMeta implements RosettaMetaData<ExtraordinaryEvents> {

	@Override
	public List<Validator<? super ExtraordinaryEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExtraordinaryEvents>create(fpml.confirmation.validation.datarule.ExtraordinaryEventsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExtraordinaryEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExtraordinaryEvents> validator() {
		return new ExtraordinaryEventsValidator();
	}

	@Override
	public Validator<? super ExtraordinaryEvents> typeFormatValidator() {
		return new ExtraordinaryEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtraordinaryEvents, Set<String>> onlyExistsValidator() {
		return new ExtraordinaryEventsOnlyExistsValidator();
	}
}
