package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessDateRange;
import fpml.confirmation.validation.BusinessDateRangeTypeFormatValidator;
import fpml.confirmation.validation.BusinessDateRangeValidator;
import fpml.confirmation.validation.exists.BusinessDateRangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BusinessDateRange.class)
public class BusinessDateRangeMeta implements RosettaMetaData<BusinessDateRange> {

	@Override
	public List<Validator<? super BusinessDateRange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessDateRange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessDateRange> validator() {
		return new BusinessDateRangeValidator();
	}

	@Override
	public Validator<? super BusinessDateRange> typeFormatValidator() {
		return new BusinessDateRangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDateRange, Set<String>> onlyExistsValidator() {
		return new BusinessDateRangeOnlyExistsValidator();
	}
}
