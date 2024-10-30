package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.validation.ClassifiablePaymentTypeFormatValidator;
import fpml.confirmation.validation.ClassifiablePaymentValidator;
import fpml.confirmation.validation.exists.ClassifiablePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClassifiablePayment.class)
public class ClassifiablePaymentMeta implements RosettaMetaData<ClassifiablePayment> {

	@Override
	public List<Validator<? super ClassifiablePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClassifiablePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClassifiablePayment> validator() {
		return new ClassifiablePaymentValidator();
	}

	@Override
	public Validator<? super ClassifiablePayment> typeFormatValidator() {
		return new ClassifiablePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClassifiablePayment, Set<String>> onlyExistsValidator() {
		return new ClassifiablePaymentOnlyExistsValidator();
	}
}
