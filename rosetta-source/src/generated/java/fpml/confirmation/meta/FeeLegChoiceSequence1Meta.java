package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeLegChoiceSequence1;
import fpml.confirmation.validation.FeeLegChoiceSequence1TypeFormatValidator;
import fpml.confirmation.validation.FeeLegChoiceSequence1Validator;
import fpml.confirmation.validation.exists.FeeLegChoiceSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FeeLegChoiceSequence1.class)
public class FeeLegChoiceSequence1Meta implements RosettaMetaData<FeeLegChoiceSequence1> {

	@Override
	public List<Validator<? super FeeLegChoiceSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FeeLegChoiceSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeeLegChoiceSequence1> validator() {
		return new FeeLegChoiceSequence1Validator();
	}

	@Override
	public Validator<? super FeeLegChoiceSequence1> typeFormatValidator() {
		return new FeeLegChoiceSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeLegChoiceSequence1, Set<String>> onlyExistsValidator() {
		return new FeeLegChoiceSequence1OnlyExistsValidator();
	}
}
