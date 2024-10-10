package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.validation.FacilityReferenceTypeFormatValidator;
import fpml.confirmation.validation.FacilityReferenceValidator;
import fpml.confirmation.validation.exists.FacilityReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityReference.class)
public class FacilityReferenceMeta implements RosettaMetaData<FacilityReference> {

	@Override
	public List<Validator<? super FacilityReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityReference> validator() {
		return new FacilityReferenceValidator();
	}

	@Override
	public Validator<? super FacilityReference> typeFormatValidator() {
		return new FacilityReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityReference, Set<String>> onlyExistsValidator() {
		return new FacilityReferenceOnlyExistsValidator();
	}
}
