package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MakeWholeAmount;
import fpml.confirmation.validation.MakeWholeAmountTypeFormatValidator;
import fpml.confirmation.validation.MakeWholeAmountValidator;
import fpml.confirmation.validation.exists.MakeWholeAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MakeWholeAmount.class)
public class MakeWholeAmountMeta implements RosettaMetaData<MakeWholeAmount> {

	@Override
	public List<Validator<? super MakeWholeAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MakeWholeAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MakeWholeAmount> validator() {
		return new MakeWholeAmountValidator();
	}

	@Override
	public Validator<? super MakeWholeAmount> typeFormatValidator() {
		return new MakeWholeAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MakeWholeAmount, Set<String>> onlyExistsValidator() {
		return new MakeWholeAmountOnlyExistsValidator();
	}
}
