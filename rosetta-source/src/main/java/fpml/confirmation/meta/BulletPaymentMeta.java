package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BulletPayment;
import fpml.confirmation.validation.BulletPaymentTypeFormatValidator;
import fpml.confirmation.validation.BulletPaymentValidator;
import fpml.confirmation.validation.exists.BulletPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BulletPayment.class)
public class BulletPaymentMeta implements RosettaMetaData<BulletPayment> {

	@Override
	public List<Validator<? super BulletPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BulletPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BulletPayment> validator() {
		return new BulletPaymentValidator();
	}

	@Override
	public Validator<? super BulletPayment> typeFormatValidator() {
		return new BulletPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BulletPayment, Set<String>> onlyExistsValidator() {
		return new BulletPaymentOnlyExistsValidator();
	}
}
