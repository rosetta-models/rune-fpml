package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Empty;
import fpml.confirmation.validation.EmptyTypeFormatValidator;
import fpml.confirmation.validation.EmptyValidator;
import fpml.confirmation.validation.exists.EmptyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Empty.class)
public class EmptyMeta implements RosettaMetaData<Empty> {

	@Override
	public List<Validator<? super Empty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Empty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Empty> validator() {
		return new EmptyValidator();
	}

	@Override
	public Validator<? super Empty> typeFormatValidator() {
		return new EmptyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Empty, Set<String>> onlyExistsValidator() {
		return new EmptyOnlyExistsValidator();
	}
}
