package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.validation.ExceptionMessageHeaderTypeFormatValidator;
import fpml.confirmation.validation.ExceptionMessageHeaderValidator;
import fpml.confirmation.validation.exists.ExceptionMessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExceptionMessageHeader.class)
public class ExceptionMessageHeaderMeta implements RosettaMetaData<ExceptionMessageHeader> {

	@Override
	public List<Validator<? super ExceptionMessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExceptionMessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExceptionMessageHeader> validator() {
		return new ExceptionMessageHeaderValidator();
	}

	@Override
	public Validator<? super ExceptionMessageHeader> typeFormatValidator() {
		return new ExceptionMessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExceptionMessageHeader, Set<String>> onlyExistsValidator() {
		return new ExceptionMessageHeaderOnlyExistsValidator();
	}
}
