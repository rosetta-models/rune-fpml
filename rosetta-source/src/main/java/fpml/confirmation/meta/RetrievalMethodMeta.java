package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RetrievalMethod;
import fpml.confirmation.validation.RetrievalMethodTypeFormatValidator;
import fpml.confirmation.validation.RetrievalMethodValidator;
import fpml.confirmation.validation.exists.RetrievalMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RetrievalMethod.class)
public class RetrievalMethodMeta implements RosettaMetaData<RetrievalMethod> {

	@Override
	public List<Validator<? super RetrievalMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RetrievalMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RetrievalMethod> validator() {
		return new RetrievalMethodValidator();
	}

	@Override
	public Validator<? super RetrievalMethod> typeFormatValidator() {
		return new RetrievalMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RetrievalMethod, Set<String>> onlyExistsValidator() {
		return new RetrievalMethodOnlyExistsValidator();
	}
}
