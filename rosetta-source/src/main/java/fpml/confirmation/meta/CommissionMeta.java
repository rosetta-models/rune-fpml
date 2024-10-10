package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Commission;
import fpml.confirmation.validation.CommissionTypeFormatValidator;
import fpml.confirmation.validation.CommissionValidator;
import fpml.confirmation.validation.exists.CommissionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Commission.class)
public class CommissionMeta implements RosettaMetaData<Commission> {

	@Override
	public List<Validator<? super Commission>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Commission, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Commission> validator() {
		return new CommissionValidator();
	}

	@Override
	public Validator<? super Commission> typeFormatValidator() {
		return new CommissionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Commission, Set<String>> onlyExistsValidator() {
		return new CommissionOnlyExistsValidator();
	}
}
