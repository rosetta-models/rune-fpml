package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionNumericStrike;
import fpml.confirmation.validation.OptionNumericStrikeTypeFormatValidator;
import fpml.confirmation.validation.OptionNumericStrikeValidator;
import fpml.confirmation.validation.exists.OptionNumericStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionNumericStrike.class)
public class OptionNumericStrikeMeta implements RosettaMetaData<OptionNumericStrike> {

	@Override
	public List<Validator<? super OptionNumericStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionNumericStrike>create(fpml.confirmation.validation.datarule.OptionNumericStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionNumericStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionNumericStrike> validator() {
		return new OptionNumericStrikeValidator();
	}

	@Override
	public Validator<? super OptionNumericStrike> typeFormatValidator() {
		return new OptionNumericStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionNumericStrike, Set<String>> onlyExistsValidator() {
		return new OptionNumericStrikeOnlyExistsValidator();
	}
}
