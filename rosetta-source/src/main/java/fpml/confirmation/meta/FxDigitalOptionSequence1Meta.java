package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDigitalOptionSequence1;
import fpml.confirmation.validation.FxDigitalOptionSequence1TypeFormatValidator;
import fpml.confirmation.validation.FxDigitalOptionSequence1Validator;
import fpml.confirmation.validation.exists.FxDigitalOptionSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxDigitalOptionSequence1.class)
public class FxDigitalOptionSequence1Meta implements RosettaMetaData<FxDigitalOptionSequence1> {

	@Override
	public List<Validator<? super FxDigitalOptionSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDigitalOptionSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDigitalOptionSequence1> validator() {
		return new FxDigitalOptionSequence1Validator();
	}

	@Override
	public Validator<? super FxDigitalOptionSequence1> typeFormatValidator() {
		return new FxDigitalOptionSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDigitalOptionSequence1, Set<String>> onlyExistsValidator() {
		return new FxDigitalOptionSequence1OnlyExistsValidator();
	}
}
