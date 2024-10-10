package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.validation.OverrideIdentifierTypeFormatValidator;
import fpml.confirmation.validation.OverrideIdentifierValidator;
import fpml.confirmation.validation.exists.OverrideIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OverrideIdentifier.class)
public class OverrideIdentifierMeta implements RosettaMetaData<OverrideIdentifier> {

	@Override
	public List<Validator<? super OverrideIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OverrideIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OverrideIdentifier> validator() {
		return new OverrideIdentifierValidator();
	}

	@Override
	public Validator<? super OverrideIdentifier> typeFormatValidator() {
		return new OverrideIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OverrideIdentifier, Set<String>> onlyExistsValidator() {
		return new OverrideIdentifierOnlyExistsValidator();
	}
}
