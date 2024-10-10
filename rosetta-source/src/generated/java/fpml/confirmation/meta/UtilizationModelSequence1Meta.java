package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UtilizationModelSequence1;
import fpml.confirmation.validation.UtilizationModelSequence1TypeFormatValidator;
import fpml.confirmation.validation.UtilizationModelSequence1Validator;
import fpml.confirmation.validation.exists.UtilizationModelSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UtilizationModelSequence1.class)
public class UtilizationModelSequence1Meta implements RosettaMetaData<UtilizationModelSequence1> {

	@Override
	public List<Validator<? super UtilizationModelSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UtilizationModelSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UtilizationModelSequence1> validator() {
		return new UtilizationModelSequence1Validator();
	}

	@Override
	public Validator<? super UtilizationModelSequence1> typeFormatValidator() {
		return new UtilizationModelSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UtilizationModelSequence1, Set<String>> onlyExistsValidator() {
		return new UtilizationModelSequence1OnlyExistsValidator();
	}
}
