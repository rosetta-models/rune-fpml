package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SimpleIRSwap;
import fpml.confirmation.validation.SimpleIRSwapTypeFormatValidator;
import fpml.confirmation.validation.SimpleIRSwapValidator;
import fpml.confirmation.validation.exists.SimpleIRSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SimpleIRSwap.class)
public class SimpleIRSwapMeta implements RosettaMetaData<SimpleIRSwap> {

	@Override
	public List<Validator<? super SimpleIRSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimpleIRSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SimpleIRSwap> validator() {
		return new SimpleIRSwapValidator();
	}

	@Override
	public Validator<? super SimpleIRSwap> typeFormatValidator() {
		return new SimpleIRSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimpleIRSwap, Set<String>> onlyExistsValidator() {
		return new SimpleIRSwapOnlyExistsValidator();
	}
}
