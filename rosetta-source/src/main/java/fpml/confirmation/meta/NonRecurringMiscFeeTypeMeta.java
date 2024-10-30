package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonRecurringMiscFeeType;
import fpml.confirmation.validation.NonRecurringMiscFeeTypeTypeFormatValidator;
import fpml.confirmation.validation.NonRecurringMiscFeeTypeValidator;
import fpml.confirmation.validation.exists.NonRecurringMiscFeeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NonRecurringMiscFeeType.class)
public class NonRecurringMiscFeeTypeMeta implements RosettaMetaData<NonRecurringMiscFeeType> {

	@Override
	public List<Validator<? super NonRecurringMiscFeeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonRecurringMiscFeeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonRecurringMiscFeeType> validator() {
		return new NonRecurringMiscFeeTypeValidator();
	}

	@Override
	public Validator<? super NonRecurringMiscFeeType> typeFormatValidator() {
		return new NonRecurringMiscFeeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonRecurringMiscFeeType, Set<String>> onlyExistsValidator() {
		return new NonRecurringMiscFeeTypeOnlyExistsValidator();
	}
}
