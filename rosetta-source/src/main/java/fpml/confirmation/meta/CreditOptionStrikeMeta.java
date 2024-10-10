package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditOptionStrike;
import fpml.confirmation.validation.CreditOptionStrikeTypeFormatValidator;
import fpml.confirmation.validation.CreditOptionStrikeValidator;
import fpml.confirmation.validation.exists.CreditOptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditOptionStrike.class)
public class CreditOptionStrikeMeta implements RosettaMetaData<CreditOptionStrike> {

	@Override
	public List<Validator<? super CreditOptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CreditOptionStrike>create(fpml.confirmation.validation.datarule.CreditOptionStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditOptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditOptionStrike> validator() {
		return new CreditOptionStrikeValidator();
	}

	@Override
	public Validator<? super CreditOptionStrike> typeFormatValidator() {
		return new CreditOptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditOptionStrike, Set<String>> onlyExistsValidator() {
		return new CreditOptionStrikeOnlyExistsValidator();
	}
}
