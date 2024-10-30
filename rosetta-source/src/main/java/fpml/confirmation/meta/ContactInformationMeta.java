package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.validation.ContactInformationTypeFormatValidator;
import fpml.confirmation.validation.ContactInformationValidator;
import fpml.confirmation.validation.exists.ContactInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ContactInformation.class)
public class ContactInformationMeta implements RosettaMetaData<ContactInformation> {

	@Override
	public List<Validator<? super ContactInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContactInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ContactInformation> validator() {
		return new ContactInformationValidator();
	}

	@Override
	public Validator<? super ContactInformation> typeFormatValidator() {
		return new ContactInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContactInformation, Set<String>> onlyExistsValidator() {
		return new ContactInformationOnlyExistsValidator();
	}
}
