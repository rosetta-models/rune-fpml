package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessDayAdjustmentsReference;
import fpml.confirmation.validation.BusinessDayAdjustmentsReferenceTypeFormatValidator;
import fpml.confirmation.validation.BusinessDayAdjustmentsReferenceValidator;
import fpml.confirmation.validation.exists.BusinessDayAdjustmentsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BusinessDayAdjustmentsReference.class)
public class BusinessDayAdjustmentsReferenceMeta implements RosettaMetaData<BusinessDayAdjustmentsReference> {

	@Override
	public List<Validator<? super BusinessDayAdjustmentsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessDayAdjustmentsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessDayAdjustmentsReference> validator() {
		return new BusinessDayAdjustmentsReferenceValidator();
	}

	@Override
	public Validator<? super BusinessDayAdjustmentsReference> typeFormatValidator() {
		return new BusinessDayAdjustmentsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDayAdjustmentsReference, Set<String>> onlyExistsValidator() {
		return new BusinessDayAdjustmentsReferenceOnlyExistsValidator();
	}
}
