package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.validation.BusinessDayAdjustmentsTypeFormatValidator;
import fpml.confirmation.validation.BusinessDayAdjustmentsValidator;
import fpml.confirmation.validation.exists.BusinessDayAdjustmentsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BusinessDayAdjustments.class)
public class BusinessDayAdjustmentsMeta implements RosettaMetaData<BusinessDayAdjustments> {

	@Override
	public List<Validator<? super BusinessDayAdjustments>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessDayAdjustments, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessDayAdjustments> validator() {
		return new BusinessDayAdjustmentsValidator();
	}

	@Override
	public Validator<? super BusinessDayAdjustments> typeFormatValidator() {
		return new BusinessDayAdjustmentsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDayAdjustments, Set<String>> onlyExistsValidator() {
		return new BusinessDayAdjustmentsOnlyExistsValidator();
	}
}
