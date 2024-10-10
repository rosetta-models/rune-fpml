package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionStrike;
import fpml.confirmation.validation.OptionStrikeTypeFormatValidator;
import fpml.confirmation.validation.OptionStrikeValidator;
import fpml.confirmation.validation.exists.OptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionStrike.class)
public class OptionStrikeMeta implements RosettaMetaData<OptionStrike> {

	@Override
	public List<Validator<? super OptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionNumericStrike>create(fpml.confirmation.validation.datarule.OptionNumericStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionStrike> validator() {
		return new OptionStrikeValidator();
	}

	@Override
	public Validator<? super OptionStrike> typeFormatValidator() {
		return new OptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionStrike, Set<String>> onlyExistsValidator() {
		return new OptionStrikeOnlyExistsValidator();
	}
}
