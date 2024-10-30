package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.validation.EquityStrikeTypeFormatValidator;
import fpml.confirmation.validation.EquityStrikeValidator;
import fpml.confirmation.validation.exists.EquityStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityStrike.class)
public class EquityStrikeMeta implements RosettaMetaData<EquityStrike> {

	@Override
	public List<Validator<? super EquityStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EquityStrike>create(fpml.confirmation.validation.datarule.EquityStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityStrike> validator() {
		return new EquityStrikeValidator();
	}

	@Override
	public Validator<? super EquityStrike> typeFormatValidator() {
		return new EquityStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityStrike, Set<String>> onlyExistsValidator() {
		return new EquityStrikeOnlyExistsValidator();
	}
}
