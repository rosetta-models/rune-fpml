package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VarianceAmount;
import fpml.confirmation.validation.VarianceAmountTypeFormatValidator;
import fpml.confirmation.validation.VarianceAmountValidator;
import fpml.confirmation.validation.exists.VarianceAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VarianceAmount.class)
public class VarianceAmountMeta implements RosettaMetaData<VarianceAmount> {

	@Override
	public List<Validator<? super VarianceAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VarianceAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VarianceAmount> validator() {
		return new VarianceAmountValidator();
	}

	@Override
	public Validator<? super VarianceAmount> typeFormatValidator() {
		return new VarianceAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceAmount, Set<String>> onlyExistsValidator() {
		return new VarianceAmountOnlyExistsValidator();
	}
}
