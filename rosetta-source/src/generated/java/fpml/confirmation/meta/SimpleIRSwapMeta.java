package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SimpleIrSwap;
import fpml.confirmation.validation.SimpleIrSwapTypeFormatValidator;
import fpml.confirmation.validation.SimpleIrSwapValidator;
import fpml.confirmation.validation.exists.SimpleIrSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model= SimpleIrSwap.class)
public class SimpleIRSwapMeta implements RosettaMetaData<SimpleIrSwap> {

	@Override
	public List<Validator<? super SimpleIrSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimpleIrSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SimpleIrSwap> validator() {
		return new SimpleIrSwapValidator();
	}

	@Override
	public Validator<? super SimpleIrSwap> typeFormatValidator() {
		return new SimpleIrSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimpleIrSwap, Set<String>> onlyExistsValidator() {
		return new SimpleIrSwapOnlyExistsValidator();
	}
}
