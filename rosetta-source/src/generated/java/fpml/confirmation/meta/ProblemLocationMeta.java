package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProblemLocation;
import fpml.confirmation.validation.ProblemLocationTypeFormatValidator;
import fpml.confirmation.validation.ProblemLocationValidator;
import fpml.confirmation.validation.exists.ProblemLocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ProblemLocation.class)
public class ProblemLocationMeta implements RosettaMetaData<ProblemLocation> {

	@Override
	public List<Validator<? super ProblemLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProblemLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProblemLocation> validator() {
		return new ProblemLocationValidator();
	}

	@Override
	public Validator<? super ProblemLocation> typeFormatValidator() {
		return new ProblemLocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProblemLocation, Set<String>> onlyExistsValidator() {
		return new ProblemLocationOnlyExistsValidator();
	}
}
