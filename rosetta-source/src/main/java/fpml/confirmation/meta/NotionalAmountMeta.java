package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.validation.NotionalAmountTypeFormatValidator;
import fpml.confirmation.validation.NotionalAmountValidator;
import fpml.confirmation.validation.exists.NotionalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NotionalAmount.class)
public class NotionalAmountMeta implements RosettaMetaData<NotionalAmount> {

	@Override
	public List<Validator<? super NotionalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotionalAmount> validator() {
		return new NotionalAmountValidator();
	}

	@Override
	public Validator<? super NotionalAmount> typeFormatValidator() {
		return new NotionalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmount, Set<String>> onlyExistsValidator() {
		return new NotionalAmountOnlyExistsValidator();
	}
}
