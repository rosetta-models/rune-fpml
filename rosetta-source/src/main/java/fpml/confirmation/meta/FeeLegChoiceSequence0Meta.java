package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.validation.FeeLegChoiceSequence0TypeFormatValidator;
import fpml.confirmation.validation.FeeLegChoiceSequence0Validator;
import fpml.confirmation.validation.exists.FeeLegChoiceSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FeeLegChoiceSequence0.class)
public class FeeLegChoiceSequence0Meta implements RosettaMetaData<FeeLegChoiceSequence0> {

	@Override
	public List<Validator<? super FeeLegChoiceSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FeeLegChoiceSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeeLegChoiceSequence0> validator() {
		return new FeeLegChoiceSequence0Validator();
	}

	@Override
	public Validator<? super FeeLegChoiceSequence0> typeFormatValidator() {
		return new FeeLegChoiceSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeLegChoiceSequence0, Set<String>> onlyExistsValidator() {
		return new FeeLegChoiceSequence0OnlyExistsValidator();
	}
}
