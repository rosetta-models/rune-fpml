package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealIdentifier;
import fpml.confirmation.validation.DealIdentifierTypeFormatValidator;
import fpml.confirmation.validation.DealIdentifierValidator;
import fpml.confirmation.validation.exists.DealIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DealIdentifier.class)
public class DealIdentifierMeta implements RosettaMetaData<DealIdentifier> {

	@Override
	public List<Validator<? super DealIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DealIdentifier> validator() {
		return new DealIdentifierValidator();
	}

	@Override
	public Validator<? super DealIdentifier> typeFormatValidator() {
		return new DealIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealIdentifier, Set<String>> onlyExistsValidator() {
		return new DealIdentifierOnlyExistsValidator();
	}
}
