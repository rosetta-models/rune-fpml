package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SingleUnderlyer;
import fpml.confirmation.validation.SingleUnderlyerTypeFormatValidator;
import fpml.confirmation.validation.SingleUnderlyerValidator;
import fpml.confirmation.validation.exists.SingleUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SingleUnderlyer.class)
public class SingleUnderlyerMeta implements RosettaMetaData<SingleUnderlyer> {

	@Override
	public List<Validator<? super SingleUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SingleUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SingleUnderlyer> validator() {
		return new SingleUnderlyerValidator();
	}

	@Override
	public Validator<? super SingleUnderlyer> typeFormatValidator() {
		return new SingleUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SingleUnderlyer, Set<String>> onlyExistsValidator() {
		return new SingleUnderlyerOnlyExistsValidator();
	}
}
