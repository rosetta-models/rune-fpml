package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditDefaultSwapOption;
import fpml.confirmation.validation.CreditDefaultSwapOptionTypeFormatValidator;
import fpml.confirmation.validation.CreditDefaultSwapOptionValidator;
import fpml.confirmation.validation.exists.CreditDefaultSwapOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditDefaultSwapOption.class)
public class CreditDefaultSwapOptionMeta implements RosettaMetaData<CreditDefaultSwapOption> {

	@Override
	public List<Validator<? super CreditDefaultSwapOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionBaseExtended>create(fpml.confirmation.validation.datarule.OptionBaseExtendedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditDefaultSwapOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditDefaultSwapOption> validator() {
		return new CreditDefaultSwapOptionValidator();
	}

	@Override
	public Validator<? super CreditDefaultSwapOption> typeFormatValidator() {
		return new CreditDefaultSwapOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDefaultSwapOption, Set<String>> onlyExistsValidator() {
		return new CreditDefaultSwapOptionOnlyExistsValidator();
	}
}
