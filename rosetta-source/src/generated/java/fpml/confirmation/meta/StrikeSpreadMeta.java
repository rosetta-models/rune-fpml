package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StrikeSpread;
import fpml.confirmation.validation.StrikeSpreadTypeFormatValidator;
import fpml.confirmation.validation.StrikeSpreadValidator;
import fpml.confirmation.validation.exists.StrikeSpreadOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StrikeSpread.class)
public class StrikeSpreadMeta implements RosettaMetaData<StrikeSpread> {

	@Override
	public List<Validator<? super StrikeSpread>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrikeSpread, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StrikeSpread> validator() {
		return new StrikeSpreadValidator();
	}

	@Override
	public Validator<? super StrikeSpread> typeFormatValidator() {
		return new StrikeSpreadTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrikeSpread, Set<String>> onlyExistsValidator() {
		return new StrikeSpreadOnlyExistsValidator();
	}
}
