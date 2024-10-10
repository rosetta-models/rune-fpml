package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.validation.LegIdentifierTypeFormatValidator;
import fpml.confirmation.validation.LegIdentifierValidator;
import fpml.confirmation.validation.exists.LegIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegIdentifier.class)
public class LegIdentifierMeta implements RosettaMetaData<LegIdentifier> {

	@Override
	public List<Validator<? super LegIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LegIdentifier> validator() {
		return new LegIdentifierValidator();
	}

	@Override
	public Validator<? super LegIdentifier> typeFormatValidator() {
		return new LegIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegIdentifier, Set<String>> onlyExistsValidator() {
		return new LegIdentifierOnlyExistsValidator();
	}
}
