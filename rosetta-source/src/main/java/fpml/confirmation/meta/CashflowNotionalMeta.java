package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.validation.CashflowNotionalTypeFormatValidator;
import fpml.confirmation.validation.CashflowNotionalValidator;
import fpml.confirmation.validation.exists.CashflowNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CashflowNotional.class)
public class CashflowNotionalMeta implements RosettaMetaData<CashflowNotional> {

	@Override
	public List<Validator<? super CashflowNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CashflowNotional>create(fpml.confirmation.validation.datarule.CashflowNotionalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CashflowNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashflowNotional> validator() {
		return new CashflowNotionalValidator();
	}

	@Override
	public Validator<? super CashflowNotional> typeFormatValidator() {
		return new CashflowNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowNotional, Set<String>> onlyExistsValidator() {
		return new CashflowNotionalOnlyExistsValidator();
	}
}
