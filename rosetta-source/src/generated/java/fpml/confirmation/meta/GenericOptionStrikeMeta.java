package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericOptionStrike;
import fpml.confirmation.validation.GenericOptionStrikeTypeFormatValidator;
import fpml.confirmation.validation.GenericOptionStrikeValidator;
import fpml.confirmation.validation.exists.GenericOptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericOptionStrike.class)
public class GenericOptionStrikeMeta implements RosettaMetaData<GenericOptionStrike> {

	@Override
	public List<Validator<? super GenericOptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EquityStrike>create(fpml.confirmation.validation.datarule.EquityStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GenericOptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericOptionStrike> validator() {
		return new GenericOptionStrikeValidator();
	}

	@Override
	public Validator<? super GenericOptionStrike> typeFormatValidator() {
		return new GenericOptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericOptionStrike, Set<String>> onlyExistsValidator() {
		return new GenericOptionStrikeOnlyExistsValidator();
	}
}
