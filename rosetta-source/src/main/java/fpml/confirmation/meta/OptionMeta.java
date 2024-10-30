package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Option;
import fpml.confirmation.validation.OptionTypeFormatValidator;
import fpml.confirmation.validation.OptionValidator;
import fpml.confirmation.validation.exists.OptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Option.class)
public class OptionMeta implements RosettaMetaData<Option> {

	@Override
	public List<Validator<? super Option>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Option, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Option> validator() {
		return new OptionValidator();
	}

	@Override
	public Validator<? super Option> typeFormatValidator() {
		return new OptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Option, Set<String>> onlyExistsValidator() {
		return new OptionOnlyExistsValidator();
	}
}
