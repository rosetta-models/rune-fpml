package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UtilizationAmounts;
import fpml.confirmation.validation.UtilizationAmountsTypeFormatValidator;
import fpml.confirmation.validation.UtilizationAmountsValidator;
import fpml.confirmation.validation.exists.UtilizationAmountsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UtilizationAmounts.class)
public class UtilizationAmountsMeta implements RosettaMetaData<UtilizationAmounts> {

	@Override
	public List<Validator<? super UtilizationAmounts>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UtilizationAmounts, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UtilizationAmounts> validator() {
		return new UtilizationAmountsValidator();
	}

	@Override
	public Validator<? super UtilizationAmounts> typeFormatValidator() {
		return new UtilizationAmountsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UtilizationAmounts, Set<String>> onlyExistsValidator() {
		return new UtilizationAmountsOnlyExistsValidator();
	}
}
