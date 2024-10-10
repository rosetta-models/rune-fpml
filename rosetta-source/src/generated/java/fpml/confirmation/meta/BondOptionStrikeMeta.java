package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondOptionStrike;
import fpml.confirmation.validation.BondOptionStrikeTypeFormatValidator;
import fpml.confirmation.validation.BondOptionStrikeValidator;
import fpml.confirmation.validation.exists.BondOptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BondOptionStrike.class)
public class BondOptionStrikeMeta implements RosettaMetaData<BondOptionStrike> {

	@Override
	public List<Validator<? super BondOptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.BondOptionStrike>create(fpml.confirmation.validation.datarule.BondOptionStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BondOptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondOptionStrike> validator() {
		return new BondOptionStrikeValidator();
	}

	@Override
	public Validator<? super BondOptionStrike> typeFormatValidator() {
		return new BondOptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondOptionStrike, Set<String>> onlyExistsValidator() {
		return new BondOptionStrikeOnlyExistsValidator();
	}
}
