package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSwap;
import fpml.confirmation.validation.FxSwapTypeFormatValidator;
import fpml.confirmation.validation.FxSwapValidator;
import fpml.confirmation.validation.exists.FxSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSwap.class)
public class FxSwapMeta implements RosettaMetaData<FxSwap> {

	@Override
	public List<Validator<? super FxSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSwap> validator() {
		return new FxSwapValidator();
	}

	@Override
	public Validator<? super FxSwap> typeFormatValidator() {
		return new FxSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSwap, Set<String>> onlyExistsValidator() {
		return new FxSwapOnlyExistsValidator();
	}
}
