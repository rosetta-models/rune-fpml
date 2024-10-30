package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Swap;
import fpml.confirmation.validation.SwapTypeFormatValidator;
import fpml.confirmation.validation.SwapValidator;
import fpml.confirmation.validation.exists.SwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Swap.class)
public class SwapMeta implements RosettaMetaData<Swap> {

	@Override
	public List<Validator<? super Swap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Swap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Swap> validator() {
		return new SwapValidator();
	}

	@Override
	public Validator<? super Swap> typeFormatValidator() {
		return new SwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Swap, Set<String>> onlyExistsValidator() {
		return new SwapOnlyExistsValidator();
	}
}
