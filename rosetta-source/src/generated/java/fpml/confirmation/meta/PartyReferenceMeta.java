package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyReference;
import fpml.confirmation.validation.PartyReferenceTypeFormatValidator;
import fpml.confirmation.validation.PartyReferenceValidator;
import fpml.confirmation.validation.exists.PartyReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyReference.class)
public class PartyReferenceMeta implements RosettaMetaData<PartyReference> {

	@Override
	public List<Validator<? super PartyReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyReference> validator() {
		return new PartyReferenceValidator();
	}

	@Override
	public Validator<? super PartyReference> typeFormatValidator() {
		return new PartyReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyReference, Set<String>> onlyExistsValidator() {
		return new PartyReferenceOnlyExistsValidator();
	}
}
