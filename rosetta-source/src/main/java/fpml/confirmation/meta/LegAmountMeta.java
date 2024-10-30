package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LegAmount;
import fpml.confirmation.validation.LegAmountTypeFormatValidator;
import fpml.confirmation.validation.LegAmountValidator;
import fpml.confirmation.validation.exists.LegAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LegAmount.class)
public class LegAmountMeta implements RosettaMetaData<LegAmount> {

	@Override
	public List<Validator<? super LegAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LegAmount>create(fpml.confirmation.validation.datarule.LegAmountChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LegAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LegAmount> validator() {
		return new LegAmountValidator();
	}

	@Override
	public Validator<? super LegAmount> typeFormatValidator() {
		return new LegAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegAmount, Set<String>> onlyExistsValidator() {
		return new LegAmountOnlyExistsValidator();
	}
}
