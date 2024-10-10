package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyerReference;
import fpml.confirmation.validation.UnderlyerReferenceTypeFormatValidator;
import fpml.confirmation.validation.UnderlyerReferenceValidator;
import fpml.confirmation.validation.exists.UnderlyerReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UnderlyerReference.class)
public class UnderlyerReferenceMeta implements RosettaMetaData<UnderlyerReference> {

	@Override
	public List<Validator<? super UnderlyerReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyerReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyerReference> validator() {
		return new UnderlyerReferenceValidator();
	}

	@Override
	public Validator<? super UnderlyerReference> typeFormatValidator() {
		return new UnderlyerReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyerReference, Set<String>> onlyExistsValidator() {
		return new UnderlyerReferenceOnlyExistsValidator();
	}
}
