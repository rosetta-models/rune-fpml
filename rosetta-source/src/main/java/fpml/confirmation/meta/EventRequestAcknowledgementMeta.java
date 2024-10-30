package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventRequestAcknowledgement;
import fpml.confirmation.validation.EventRequestAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.EventRequestAcknowledgementValidator;
import fpml.confirmation.validation.exists.EventRequestAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EventRequestAcknowledgement.class)
public class EventRequestAcknowledgementMeta implements RosettaMetaData<EventRequestAcknowledgement> {

	@Override
	public List<Validator<? super EventRequestAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventRequestAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventRequestAcknowledgement> validator() {
		return new EventRequestAcknowledgementValidator();
	}

	@Override
	public Validator<? super EventRequestAcknowledgement> typeFormatValidator() {
		return new EventRequestAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventRequestAcknowledgement, Set<String>> onlyExistsValidator() {
		return new EventRequestAcknowledgementOnlyExistsValidator();
	}
}
