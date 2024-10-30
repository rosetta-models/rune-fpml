package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOption;
import fpml.confirmation.validation.FxOptionTypeFormatValidator;
import fpml.confirmation.validation.FxOptionValidator;
import fpml.confirmation.validation.exists.FxOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxOption.class)
public class FxOptionMeta implements RosettaMetaData<FxOption> {

	@Override
	public List<Validator<? super FxOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxOption>create(fpml.confirmation.validation.datarule.FxOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOption> validator() {
		return new FxOptionValidator();
	}

	@Override
	public Validator<? super FxOption> typeFormatValidator() {
		return new FxOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOption, Set<String>> onlyExistsValidator() {
		return new FxOptionOnlyExistsValidator();
	}
}
