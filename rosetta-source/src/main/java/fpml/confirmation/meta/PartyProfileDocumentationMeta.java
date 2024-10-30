package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyProfileDocumentation;
import fpml.confirmation.validation.PartyProfileDocumentationTypeFormatValidator;
import fpml.confirmation.validation.PartyProfileDocumentationValidator;
import fpml.confirmation.validation.exists.PartyProfileDocumentationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyProfileDocumentation.class)
public class PartyProfileDocumentationMeta implements RosettaMetaData<PartyProfileDocumentation> {

	@Override
	public List<Validator<? super PartyProfileDocumentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyProfileDocumentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyProfileDocumentation> validator() {
		return new PartyProfileDocumentationValidator();
	}

	@Override
	public Validator<? super PartyProfileDocumentation> typeFormatValidator() {
		return new PartyProfileDocumentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfileDocumentation, Set<String>> onlyExistsValidator() {
		return new PartyProfileDocumentationOnlyExistsValidator();
	}
}
