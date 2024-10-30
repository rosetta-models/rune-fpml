package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.validation.UnprocessedElementWrapperTypeFormatValidator;
import fpml.confirmation.validation.UnprocessedElementWrapperValidator;
import fpml.confirmation.validation.exists.UnprocessedElementWrapperOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=UnprocessedElementWrapper.class)
public class UnprocessedElementWrapperMeta implements RosettaMetaData<UnprocessedElementWrapper> {

	@Override
	public List<Validator<? super UnprocessedElementWrapper>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnprocessedElementWrapper, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnprocessedElementWrapper> validator() {
		return new UnprocessedElementWrapperValidator();
	}

	@Override
	public Validator<? super UnprocessedElementWrapper> typeFormatValidator() {
		return new UnprocessedElementWrapperTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnprocessedElementWrapper, Set<String>> onlyExistsValidator() {
		return new UnprocessedElementWrapperOnlyExistsValidator();
	}
}
