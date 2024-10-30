package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualStrike;
import fpml.confirmation.validation.FxAccrualStrikeTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualStrikeValidator;
import fpml.confirmation.validation.exists.FxAccrualStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualStrike.class)
public class FxAccrualStrikeMeta implements RosettaMetaData<FxAccrualStrike> {

	@Override
	public List<Validator<? super FxAccrualStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualStrike> validator() {
		return new FxAccrualStrikeValidator();
	}

	@Override
	public Validator<? super FxAccrualStrike> typeFormatValidator() {
		return new FxAccrualStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualStrike, Set<String>> onlyExistsValidator() {
		return new FxAccrualStrikeOnlyExistsValidator();
	}
}
