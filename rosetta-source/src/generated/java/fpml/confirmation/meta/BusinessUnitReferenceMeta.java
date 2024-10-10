package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.validation.BusinessUnitReferenceTypeFormatValidator;
import fpml.confirmation.validation.BusinessUnitReferenceValidator;
import fpml.confirmation.validation.exists.BusinessUnitReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BusinessUnitReference.class)
public class BusinessUnitReferenceMeta implements RosettaMetaData<BusinessUnitReference> {

	@Override
	public List<Validator<? super BusinessUnitReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessUnitReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessUnitReference> validator() {
		return new BusinessUnitReferenceValidator();
	}

	@Override
	public Validator<? super BusinessUnitReference> typeFormatValidator() {
		return new BusinessUnitReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessUnitReference, Set<String>> onlyExistsValidator() {
		return new BusinessUnitReferenceOnlyExistsValidator();
	}
}
