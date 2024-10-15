package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DefaultRateExpiry;
import fpml.confirmation.validation.DefaultRateExpiryTypeFormatValidator;
import fpml.confirmation.validation.DefaultRateExpiryValidator;
import fpml.confirmation.validation.exists.DefaultRateExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DefaultRateExpiry.class)
public class DefaultRateExpiryMeta implements RosettaMetaData<DefaultRateExpiry> {

	@Override
	public List<Validator<? super DefaultRateExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DefaultRateExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DefaultRateExpiry> validator() {
		return new DefaultRateExpiryValidator();
	}

	@Override
	public Validator<? super DefaultRateExpiry> typeFormatValidator() {
		return new DefaultRateExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DefaultRateExpiry, Set<String>> onlyExistsValidator() {
		return new DefaultRateExpiryOnlyExistsValidator();
	}
}
