package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CountryCode;
import fpml.confirmation.validation.CountryCodeTypeFormatValidator;
import fpml.confirmation.validation.CountryCodeValidator;
import fpml.confirmation.validation.exists.CountryCodeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CountryCode.class)
public class CountryCodeMeta implements RosettaMetaData<CountryCode> {

	@Override
	public List<Validator<? super CountryCode>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CountryCode, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CountryCode> validator() {
		return new CountryCodeValidator();
	}

	@Override
	public Validator<? super CountryCode> typeFormatValidator() {
		return new CountryCodeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CountryCode, Set<String>> onlyExistsValidator() {
		return new CountryCodeOnlyExistsValidator();
	}
}
