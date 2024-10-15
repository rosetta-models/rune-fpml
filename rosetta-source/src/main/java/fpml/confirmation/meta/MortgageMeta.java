package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Mortgage;
import fpml.confirmation.validation.MortgageTypeFormatValidator;
import fpml.confirmation.validation.MortgageValidator;
import fpml.confirmation.validation.exists.MortgageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Mortgage.class)
public class MortgageMeta implements RosettaMetaData<Mortgage> {

	@Override
	public List<Validator<? super Mortgage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Mortgage>create(fpml.confirmation.validation.datarule.MortgageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Mortgage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Mortgage> validator() {
		return new MortgageValidator();
	}

	@Override
	public Validator<? super Mortgage> typeFormatValidator() {
		return new MortgageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Mortgage, Set<String>> onlyExistsValidator() {
		return new MortgageOnlyExistsValidator();
	}
}
