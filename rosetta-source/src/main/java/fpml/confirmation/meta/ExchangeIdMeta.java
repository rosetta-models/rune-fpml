package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.validation.ExchangeIdTypeFormatValidator;
import fpml.confirmation.validation.ExchangeIdValidator;
import fpml.confirmation.validation.exists.ExchangeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeId.class)
public class ExchangeIdMeta implements RosettaMetaData<ExchangeId> {

	@Override
	public List<Validator<? super ExchangeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeId> validator() {
		return new ExchangeIdValidator();
	}

	@Override
	public Validator<? super ExchangeId> typeFormatValidator() {
		return new ExchangeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeId, Set<String>> onlyExistsValidator() {
		return new ExchangeIdOnlyExistsValidator();
	}
}
