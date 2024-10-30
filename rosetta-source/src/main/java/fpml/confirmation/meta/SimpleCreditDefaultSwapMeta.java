package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SimpleCreditDefaultSwap;
import fpml.confirmation.validation.SimpleCreditDefaultSwapTypeFormatValidator;
import fpml.confirmation.validation.SimpleCreditDefaultSwapValidator;
import fpml.confirmation.validation.exists.SimpleCreditDefaultSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SimpleCreditDefaultSwap.class)
public class SimpleCreditDefaultSwapMeta implements RosettaMetaData<SimpleCreditDefaultSwap> {

	@Override
	public List<Validator<? super SimpleCreditDefaultSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimpleCreditDefaultSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SimpleCreditDefaultSwap> validator() {
		return new SimpleCreditDefaultSwapValidator();
	}

	@Override
	public Validator<? super SimpleCreditDefaultSwap> typeFormatValidator() {
		return new SimpleCreditDefaultSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimpleCreditDefaultSwap, Set<String>> onlyExistsValidator() {
		return new SimpleCreditDefaultSwapOnlyExistsValidator();
	}
}
