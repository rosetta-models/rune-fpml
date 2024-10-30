package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Notional;
import fpml.confirmation.validation.NotionalTypeFormatValidator;
import fpml.confirmation.validation.NotionalValidator;
import fpml.confirmation.validation.exists.NotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Notional.class)
public class NotionalMeta implements RosettaMetaData<Notional> {

	@Override
	public List<Validator<? super Notional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Notional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Notional> validator() {
		return new NotionalValidator();
	}

	@Override
	public Validator<? super Notional> typeFormatValidator() {
		return new NotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Notional, Set<String>> onlyExistsValidator() {
		return new NotionalOnlyExistsValidator();
	}
}
