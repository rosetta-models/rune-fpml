package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.validation.CreditSeniorityTypeFormatValidator;
import fpml.confirmation.validation.CreditSeniorityValidator;
import fpml.confirmation.validation.exists.CreditSeniorityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditSeniority.class)
public class CreditSeniorityMeta implements RosettaMetaData<CreditSeniority> {

	@Override
	public List<Validator<? super CreditSeniority>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSeniority, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditSeniority> validator() {
		return new CreditSeniorityValidator();
	}

	@Override
	public Validator<? super CreditSeniority> typeFormatValidator() {
		return new CreditSeniorityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSeniority, Set<String>> onlyExistsValidator() {
		return new CreditSeniorityOnlyExistsValidator();
	}
}
