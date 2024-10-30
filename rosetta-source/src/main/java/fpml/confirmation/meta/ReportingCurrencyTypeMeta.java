package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingCurrencyType;
import fpml.confirmation.validation.ReportingCurrencyTypeTypeFormatValidator;
import fpml.confirmation.validation.ReportingCurrencyTypeValidator;
import fpml.confirmation.validation.exists.ReportingCurrencyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingCurrencyType.class)
public class ReportingCurrencyTypeMeta implements RosettaMetaData<ReportingCurrencyType> {

	@Override
	public List<Validator<? super ReportingCurrencyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingCurrencyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingCurrencyType> validator() {
		return new ReportingCurrencyTypeValidator();
	}

	@Override
	public Validator<? super ReportingCurrencyType> typeFormatValidator() {
		return new ReportingCurrencyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingCurrencyType, Set<String>> onlyExistsValidator() {
		return new ReportingCurrencyTypeOnlyExistsValidator();
	}
}
