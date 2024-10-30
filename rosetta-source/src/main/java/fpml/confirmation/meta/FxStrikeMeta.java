package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxStrike;
import fpml.confirmation.validation.FxStrikeTypeFormatValidator;
import fpml.confirmation.validation.FxStrikeValidator;
import fpml.confirmation.validation.exists.FxStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxStrike.class)
public class FxStrikeMeta implements RosettaMetaData<FxStrike> {

	@Override
	public List<Validator<? super FxStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxStrike> validator() {
		return new FxStrikeValidator();
	}

	@Override
	public Validator<? super FxStrike> typeFormatValidator() {
		return new FxStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxStrike, Set<String>> onlyExistsValidator() {
		return new FxStrikeOnlyExistsValidator();
	}
}
