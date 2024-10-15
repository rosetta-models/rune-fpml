package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1;
import fpml.confirmation.validation.AccrualOptionChangeNotificationSequence1TypeFormatValidator;
import fpml.confirmation.validation.AccrualOptionChangeNotificationSequence1Validator;
import fpml.confirmation.validation.exists.AccrualOptionChangeNotificationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccrualOptionChangeNotificationSequence1.class)
public class AccrualOptionChangeNotificationSequence1Meta implements RosettaMetaData<AccrualOptionChangeNotificationSequence1> {

	@Override
	public List<Validator<? super AccrualOptionChangeNotificationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccrualOptionChangeNotificationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccrualOptionChangeNotificationSequence1> validator() {
		return new AccrualOptionChangeNotificationSequence1Validator();
	}

	@Override
	public Validator<? super AccrualOptionChangeNotificationSequence1> typeFormatValidator() {
		return new AccrualOptionChangeNotificationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualOptionChangeNotificationSequence1, Set<String>> onlyExistsValidator() {
		return new AccrualOptionChangeNotificationSequence1OnlyExistsValidator();
	}
}
