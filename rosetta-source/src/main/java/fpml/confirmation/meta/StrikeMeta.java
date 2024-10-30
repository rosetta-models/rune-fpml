package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Strike;
import fpml.confirmation.validation.StrikeTypeFormatValidator;
import fpml.confirmation.validation.StrikeValidator;
import fpml.confirmation.validation.exists.StrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Strike.class)
public class StrikeMeta implements RosettaMetaData<Strike> {

	@Override
	public List<Validator<? super Strike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Strike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Strike> validator() {
		return new StrikeValidator();
	}

	@Override
	public Validator<? super Strike> typeFormatValidator() {
		return new StrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Strike, Set<String>> onlyExistsValidator() {
		return new StrikeOnlyExistsValidator();
	}
}
