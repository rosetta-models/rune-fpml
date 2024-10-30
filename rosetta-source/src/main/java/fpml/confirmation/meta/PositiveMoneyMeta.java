package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.validation.PositiveMoneyTypeFormatValidator;
import fpml.confirmation.validation.PositiveMoneyValidator;
import fpml.confirmation.validation.exists.PositiveMoneyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PositiveMoney.class)
public class PositiveMoneyMeta implements RosettaMetaData<PositiveMoney> {

	@Override
	public List<Validator<? super PositiveMoney>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PositiveMoney, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PositiveMoney> validator() {
		return new PositiveMoneyValidator();
	}

	@Override
	public Validator<? super PositiveMoney> typeFormatValidator() {
		return new PositiveMoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PositiveMoney, Set<String>> onlyExistsValidator() {
		return new PositiveMoneyOnlyExistsValidator();
	}
}
