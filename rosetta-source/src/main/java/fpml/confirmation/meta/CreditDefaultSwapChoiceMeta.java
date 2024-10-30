package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditDefaultSwapChoice;
import fpml.confirmation.validation.CreditDefaultSwapChoiceTypeFormatValidator;
import fpml.confirmation.validation.CreditDefaultSwapChoiceValidator;
import fpml.confirmation.validation.exists.CreditDefaultSwapChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditDefaultSwapChoice.class)
public class CreditDefaultSwapChoiceMeta implements RosettaMetaData<CreditDefaultSwapChoice> {

	@Override
	public List<Validator<? super CreditDefaultSwapChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CreditDefaultSwapChoice>create(fpml.confirmation.validation.datarule.CreditDefaultSwapChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditDefaultSwapChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditDefaultSwapChoice> validator() {
		return new CreditDefaultSwapChoiceValidator();
	}

	@Override
	public Validator<? super CreditDefaultSwapChoice> typeFormatValidator() {
		return new CreditDefaultSwapChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDefaultSwapChoice, Set<String>> onlyExistsValidator() {
		return new CreditDefaultSwapChoiceOnlyExistsValidator();
	}
}
