package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PassThrough;
import fpml.confirmation.validation.PassThroughTypeFormatValidator;
import fpml.confirmation.validation.PassThroughValidator;
import fpml.confirmation.validation.exists.PassThroughOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PassThrough.class)
public class PassThroughMeta implements RosettaMetaData<PassThrough> {

	@Override
	public List<Validator<? super PassThrough>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PassThrough, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PassThrough> validator() {
		return new PassThroughValidator();
	}

	@Override
	public Validator<? super PassThrough> typeFormatValidator() {
		return new PassThroughTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PassThrough, Set<String>> onlyExistsValidator() {
		return new PassThroughOnlyExistsValidator();
	}
}
