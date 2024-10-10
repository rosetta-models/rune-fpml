package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EvergreenOption;
import fpml.confirmation.validation.EvergreenOptionTypeFormatValidator;
import fpml.confirmation.validation.EvergreenOptionValidator;
import fpml.confirmation.validation.exists.EvergreenOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EvergreenOption.class)
public class EvergreenOptionMeta implements RosettaMetaData<EvergreenOption> {

	@Override
	public List<Validator<? super EvergreenOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EvergreenOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EvergreenOption> validator() {
		return new EvergreenOptionValidator();
	}

	@Override
	public Validator<? super EvergreenOption> typeFormatValidator() {
		return new EvergreenOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EvergreenOption, Set<String>> onlyExistsValidator() {
		return new EvergreenOptionOnlyExistsValidator();
	}
}
