package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Future;
import fpml.confirmation.validation.FutureTypeFormatValidator;
import fpml.confirmation.validation.FutureValidator;
import fpml.confirmation.validation.exists.FutureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Future.class)
public class FutureMeta implements RosettaMetaData<Future> {

	@Override
	public List<Validator<? super Future>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Future>create(fpml.confirmation.validation.datarule.FutureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Future, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Future> validator() {
		return new FutureValidator();
	}

	@Override
	public Validator<? super Future> typeFormatValidator() {
		return new FutureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Future, Set<String>> onlyExistsValidator() {
		return new FutureOnlyExistsValidator();
	}
}
