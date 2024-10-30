package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendConditions;
import fpml.confirmation.validation.DividendConditionsTypeFormatValidator;
import fpml.confirmation.validation.DividendConditionsValidator;
import fpml.confirmation.validation.exists.DividendConditionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendConditions.class)
public class DividendConditionsMeta implements RosettaMetaData<DividendConditions> {

	@Override
	public List<Validator<? super DividendConditions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DividendConditions>create(fpml.confirmation.validation.datarule.DividendConditionsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendConditions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendConditions> validator() {
		return new DividendConditionsValidator();
	}

	@Override
	public Validator<? super DividendConditions> typeFormatValidator() {
		return new DividendConditionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendConditions, Set<String>> onlyExistsValidator() {
		return new DividendConditionsOnlyExistsValidator();
	}
}
