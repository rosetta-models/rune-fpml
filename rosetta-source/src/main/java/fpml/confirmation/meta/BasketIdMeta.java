package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketId;
import fpml.confirmation.validation.BasketIdTypeFormatValidator;
import fpml.confirmation.validation.BasketIdValidator;
import fpml.confirmation.validation.exists.BasketIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BasketId.class)
public class BasketIdMeta implements RosettaMetaData<BasketId> {

	@Override
	public List<Validator<? super BasketId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketId> validator() {
		return new BasketIdValidator();
	}

	@Override
	public Validator<? super BasketId> typeFormatValidator() {
		return new BasketIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketId, Set<String>> onlyExistsValidator() {
		return new BasketIdOnlyExistsValidator();
	}
}
