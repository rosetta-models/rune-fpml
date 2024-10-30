package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendPeriodDividend;
import fpml.confirmation.validation.DividendPeriodDividendTypeFormatValidator;
import fpml.confirmation.validation.DividendPeriodDividendValidator;
import fpml.confirmation.validation.exists.DividendPeriodDividendOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendPeriodDividend.class)
public class DividendPeriodDividendMeta implements RosettaMetaData<DividendPeriodDividend> {

	@Override
	public List<Validator<? super DividendPeriodDividend>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendPeriodDividend, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendPeriodDividend> validator() {
		return new DividendPeriodDividendValidator();
	}

	@Override
	public Validator<? super DividendPeriodDividend> typeFormatValidator() {
		return new DividendPeriodDividendTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPeriodDividend, Set<String>> onlyExistsValidator() {
		return new DividendPeriodDividendOnlyExistsValidator();
	}
}
