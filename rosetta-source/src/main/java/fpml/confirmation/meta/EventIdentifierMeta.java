package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventIdentifier;
import fpml.confirmation.validation.EventIdentifierTypeFormatValidator;
import fpml.confirmation.validation.EventIdentifierValidator;
import fpml.confirmation.validation.exists.EventIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EventIdentifier.class)
public class EventIdentifierMeta implements RosettaMetaData<EventIdentifier> {

	@Override
	public List<Validator<? super EventIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EventIdentifier>create(fpml.confirmation.validation.datarule.EventIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventIdentifier> validator() {
		return new EventIdentifierValidator();
	}

	@Override
	public Validator<? super EventIdentifier> typeFormatValidator() {
		return new EventIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventIdentifier, Set<String>> onlyExistsValidator() {
		return new EventIdentifierOnlyExistsValidator();
	}
}
