package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDigitalOptionSequence0;
import fpml.confirmation.validation.FxDigitalOptionSequence0TypeFormatValidator;
import fpml.confirmation.validation.FxDigitalOptionSequence0Validator;
import fpml.confirmation.validation.exists.FxDigitalOptionSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxDigitalOptionSequence0.class)
public class FxDigitalOptionSequence0Meta implements RosettaMetaData<FxDigitalOptionSequence0> {

	@Override
	public List<Validator<? super FxDigitalOptionSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDigitalOptionSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDigitalOptionSequence0> validator() {
		return new FxDigitalOptionSequence0Validator();
	}

	@Override
	public Validator<? super FxDigitalOptionSequence0> typeFormatValidator() {
		return new FxDigitalOptionSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDigitalOptionSequence0, Set<String>> onlyExistsValidator() {
		return new FxDigitalOptionSequence0OnlyExistsValidator();
	}
}
