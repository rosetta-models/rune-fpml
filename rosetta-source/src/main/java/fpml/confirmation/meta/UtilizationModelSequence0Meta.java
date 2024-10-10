package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UtilizationModelSequence0;
import fpml.confirmation.validation.UtilizationModelSequence0TypeFormatValidator;
import fpml.confirmation.validation.UtilizationModelSequence0Validator;
import fpml.confirmation.validation.exists.UtilizationModelSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UtilizationModelSequence0.class)
public class UtilizationModelSequence0Meta implements RosettaMetaData<UtilizationModelSequence0> {

	@Override
	public List<Validator<? super UtilizationModelSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UtilizationModelSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UtilizationModelSequence0> validator() {
		return new UtilizationModelSequence0Validator();
	}

	@Override
	public Validator<? super UtilizationModelSequence0> typeFormatValidator() {
		return new UtilizationModelSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UtilizationModelSequence0, Set<String>> onlyExistsValidator() {
		return new UtilizationModelSequence0OnlyExistsValidator();
	}
}
