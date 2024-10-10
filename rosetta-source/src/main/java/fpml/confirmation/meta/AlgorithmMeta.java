package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Algorithm;
import fpml.confirmation.validation.AlgorithmTypeFormatValidator;
import fpml.confirmation.validation.AlgorithmValidator;
import fpml.confirmation.validation.exists.AlgorithmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Algorithm.class)
public class AlgorithmMeta implements RosettaMetaData<Algorithm> {

	@Override
	public List<Validator<? super Algorithm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Algorithm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Algorithm> validator() {
		return new AlgorithmValidator();
	}

	@Override
	public Validator<? super Algorithm> typeFormatValidator() {
		return new AlgorithmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Algorithm, Set<String>> onlyExistsValidator() {
		return new AlgorithmOnlyExistsValidator();
	}
}
