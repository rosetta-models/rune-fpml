package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventsChoice;
import fpml.confirmation.validation.EventsChoiceTypeFormatValidator;
import fpml.confirmation.validation.EventsChoiceValidator;
import fpml.confirmation.validation.exists.EventsChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EventsChoice.class)
public class EventsChoiceMeta implements RosettaMetaData<EventsChoice> {

	@Override
	public List<Validator<? super EventsChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EventsChoice>create(fpml.confirmation.validation.datarule.EventsChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventsChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventsChoice> validator() {
		return new EventsChoiceValidator();
	}

	@Override
	public Validator<? super EventsChoice> typeFormatValidator() {
		return new EventsChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventsChoice, Set<String>> onlyExistsValidator() {
		return new EventsChoiceOnlyExistsValidator();
	}
}
