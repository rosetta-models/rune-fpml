package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import fpml.confirmation.validation.AccrualOptionChangeNotificationSequence0TypeFormatValidator;
import fpml.confirmation.validation.AccrualOptionChangeNotificationSequence0Validator;
import fpml.confirmation.validation.exists.AccrualOptionChangeNotificationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccrualOptionChangeNotificationSequence0.class)
public class AccrualOptionChangeNotificationSequence0Meta implements RosettaMetaData<AccrualOptionChangeNotificationSequence0> {

	@Override
	public List<Validator<? super AccrualOptionChangeNotificationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AccrualOptionChangeNotificationSequence0>create(fpml.confirmation.validation.datarule.AccrualOptionChangeNotificationSequence0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AccrualOptionChangeNotificationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccrualOptionChangeNotificationSequence0> validator() {
		return new AccrualOptionChangeNotificationSequence0Validator();
	}

	@Override
	public Validator<? super AccrualOptionChangeNotificationSequence0> typeFormatValidator() {
		return new AccrualOptionChangeNotificationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualOptionChangeNotificationSequence0, Set<String>> onlyExistsValidator() {
		return new AccrualOptionChangeNotificationSequence0OnlyExistsValidator();
	}
}
