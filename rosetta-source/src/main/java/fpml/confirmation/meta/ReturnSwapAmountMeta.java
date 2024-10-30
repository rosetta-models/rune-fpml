package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapAmount;
import fpml.confirmation.validation.ReturnSwapAmountTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapAmountValidator;
import fpml.confirmation.validation.exists.ReturnSwapAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReturnSwapAmount.class)
public class ReturnSwapAmountMeta implements RosettaMetaData<ReturnSwapAmount> {

	@Override
	public List<Validator<? super ReturnSwapAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LegAmount>create(fpml.confirmation.validation.datarule.LegAmountChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapAmount> validator() {
		return new ReturnSwapAmountValidator();
	}

	@Override
	public Validator<? super ReturnSwapAmount> typeFormatValidator() {
		return new ReturnSwapAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapAmount, Set<String>> onlyExistsValidator() {
		return new ReturnSwapAmountOnlyExistsValidator();
	}
}
