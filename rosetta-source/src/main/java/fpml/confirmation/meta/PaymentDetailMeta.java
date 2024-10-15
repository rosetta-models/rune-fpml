package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentDetail;
import fpml.confirmation.validation.PaymentDetailTypeFormatValidator;
import fpml.confirmation.validation.PaymentDetailValidator;
import fpml.confirmation.validation.exists.PaymentDetailOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaymentDetail.class)
public class PaymentDetailMeta implements RosettaMetaData<PaymentDetail> {

	@Override
	public List<Validator<? super PaymentDetail>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PaymentDetail>create(fpml.confirmation.validation.datarule.PaymentDetailChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PaymentDetail, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentDetail> validator() {
		return new PaymentDetailValidator();
	}

	@Override
	public Validator<? super PaymentDetail> typeFormatValidator() {
		return new PaymentDetailTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDetail, Set<String>> onlyExistsValidator() {
		return new PaymentDetailOnlyExistsValidator();
	}
}
