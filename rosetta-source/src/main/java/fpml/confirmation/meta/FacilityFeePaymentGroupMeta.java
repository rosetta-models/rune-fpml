package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityFeePaymentGroup;
import fpml.confirmation.validation.FacilityFeePaymentGroupTypeFormatValidator;
import fpml.confirmation.validation.FacilityFeePaymentGroupValidator;
import fpml.confirmation.validation.exists.FacilityFeePaymentGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityFeePaymentGroup.class)
public class FacilityFeePaymentGroupMeta implements RosettaMetaData<FacilityFeePaymentGroup> {

	@Override
	public List<Validator<? super FacilityFeePaymentGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityFeePaymentGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityFeePaymentGroup> validator() {
		return new FacilityFeePaymentGroupValidator();
	}

	@Override
	public Validator<? super FacilityFeePaymentGroup> typeFormatValidator() {
		return new FacilityFeePaymentGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityFeePaymentGroup, Set<String>> onlyExistsValidator() {
		return new FacilityFeePaymentGroupOnlyExistsValidator();
	}
}
