package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Money;
import fpml.confirmation.validation.MoneyTypeFormatValidator;
import fpml.confirmation.validation.MoneyValidator;
import fpml.confirmation.validation.exists.MoneyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Money.class)
public class MoneyMeta implements RosettaMetaData<Money> {

	@Override
	public List<Validator<? super Money>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Money, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Money> validator() {
		return new MoneyValidator();
	}

	@Override
	public Validator<? super Money> typeFormatValidator() {
		return new MoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Money, Set<String>> onlyExistsValidator() {
		return new MoneyOnlyExistsValidator();
	}
}
