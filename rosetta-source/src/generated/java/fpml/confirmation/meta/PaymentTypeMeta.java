package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentType;
import fpml.confirmation.validation.PaymentTypeTypeFormatValidator;
import fpml.confirmation.validation.PaymentTypeValidator;
import fpml.confirmation.validation.exists.PaymentTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaymentType.class)
public class PaymentTypeMeta implements RosettaMetaData<PaymentType> {

	@Override
	public List<Validator<? super PaymentType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentType> validator() {
		return new PaymentTypeValidator();
	}

	@Override
	public Validator<? super PaymentType> typeFormatValidator() {
		return new PaymentTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentType, Set<String>> onlyExistsValidator() {
		return new PaymentTypeOnlyExistsValidator();
	}
}
