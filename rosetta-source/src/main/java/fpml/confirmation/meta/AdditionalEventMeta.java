package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.validation.AdditionalEventTypeFormatValidator;
import fpml.confirmation.validation.AdditionalEventValidator;
import fpml.confirmation.validation.exists.AdditionalEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdditionalEvent.class)
public class AdditionalEventMeta implements RosettaMetaData<AdditionalEvent> {

	@Override
	public List<Validator<? super AdditionalEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdditionalEvent> validator() {
		return new AdditionalEventValidator();
	}

	@Override
	public Validator<? super AdditionalEvent> typeFormatValidator() {
		return new AdditionalEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalEvent, Set<String>> onlyExistsValidator() {
		return new AdditionalEventOnlyExistsValidator();
	}
}
