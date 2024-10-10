package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.validation.NonNegativeMoneyTypeFormatValidator;
import fpml.confirmation.validation.NonNegativeMoneyValidator;
import fpml.confirmation.validation.exists.NonNegativeMoneyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NonNegativeMoney.class)
public class NonNegativeMoneyMeta implements RosettaMetaData<NonNegativeMoney> {

	@Override
	public List<Validator<? super NonNegativeMoney>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeMoney, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonNegativeMoney> validator() {
		return new NonNegativeMoneyValidator();
	}

	@Override
	public Validator<? super NonNegativeMoney> typeFormatValidator() {
		return new NonNegativeMoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeMoney, Set<String>> onlyExistsValidator() {
		return new NonNegativeMoneyOnlyExistsValidator();
	}
}
