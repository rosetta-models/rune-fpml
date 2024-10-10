package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Cash;
import fpml.confirmation.validation.CashTypeFormatValidator;
import fpml.confirmation.validation.CashValidator;
import fpml.confirmation.validation.exists.CashOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Cash.class)
public class CashMeta implements RosettaMetaData<Cash> {

	@Override
	public List<Validator<? super Cash>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Cash, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Cash> validator() {
		return new CashValidator();
	}

	@Override
	public Validator<? super Cash> typeFormatValidator() {
		return new CashTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Cash, Set<String>> onlyExistsValidator() {
		return new CashOnlyExistsValidator();
	}
}
