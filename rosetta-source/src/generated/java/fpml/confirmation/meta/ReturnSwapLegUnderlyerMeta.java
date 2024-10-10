package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapLegUnderlyer;
import fpml.confirmation.validation.ReturnSwapLegUnderlyerTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapLegUnderlyerValidator;
import fpml.confirmation.validation.exists.ReturnSwapLegUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReturnSwapLegUnderlyer.class)
public class ReturnSwapLegUnderlyerMeta implements RosettaMetaData<ReturnSwapLegUnderlyer> {

	@Override
	public List<Validator<? super ReturnSwapLegUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapLegUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapLegUnderlyer> validator() {
		return new ReturnSwapLegUnderlyerValidator();
	}

	@Override
	public Validator<? super ReturnSwapLegUnderlyer> typeFormatValidator() {
		return new ReturnSwapLegUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapLegUnderlyer, Set<String>> onlyExistsValidator() {
		return new ReturnSwapLegUnderlyerOnlyExistsValidator();
	}
}
