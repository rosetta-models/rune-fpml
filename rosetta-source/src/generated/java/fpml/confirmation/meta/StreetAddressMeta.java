package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StreetAddress;
import fpml.confirmation.validation.StreetAddressTypeFormatValidator;
import fpml.confirmation.validation.StreetAddressValidator;
import fpml.confirmation.validation.exists.StreetAddressOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StreetAddress.class)
public class StreetAddressMeta implements RosettaMetaData<StreetAddress> {

	@Override
	public List<Validator<? super StreetAddress>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StreetAddress, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StreetAddress> validator() {
		return new StreetAddressValidator();
	}

	@Override
	public Validator<? super StreetAddress> typeFormatValidator() {
		return new StreetAddressTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StreetAddress, Set<String>> onlyExistsValidator() {
		return new StreetAddressOnlyExistsValidator();
	}
}
