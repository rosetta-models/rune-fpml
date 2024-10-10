package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendPaymentDate;
import fpml.confirmation.validation.DividendPaymentDateTypeFormatValidator;
import fpml.confirmation.validation.DividendPaymentDateValidator;
import fpml.confirmation.validation.exists.DividendPaymentDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DividendPaymentDate.class)
public class DividendPaymentDateMeta implements RosettaMetaData<DividendPaymentDate> {

	@Override
	public List<Validator<? super DividendPaymentDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DividendPaymentDate>create(fpml.confirmation.validation.datarule.DividendPaymentDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendPaymentDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendPaymentDate> validator() {
		return new DividendPaymentDateValidator();
	}

	@Override
	public Validator<? super DividendPaymentDate> typeFormatValidator() {
		return new DividendPaymentDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPaymentDate, Set<String>> onlyExistsValidator() {
		return new DividendPaymentDateOnlyExistsValidator();
	}
}
