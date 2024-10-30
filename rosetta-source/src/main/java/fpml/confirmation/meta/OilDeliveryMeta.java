package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OilDelivery;
import fpml.confirmation.validation.OilDeliveryTypeFormatValidator;
import fpml.confirmation.validation.OilDeliveryValidator;
import fpml.confirmation.validation.exists.OilDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OilDelivery.class)
public class OilDeliveryMeta implements RosettaMetaData<OilDelivery> {

	@Override
	public List<Validator<? super OilDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OilDelivery>create(fpml.confirmation.validation.datarule.OilDeliveryChoice0.class),
			factory.<fpml.confirmation.OilDelivery>create(fpml.confirmation.validation.datarule.OilDeliveryChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super OilDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OilDelivery> validator() {
		return new OilDeliveryValidator();
	}

	@Override
	public Validator<? super OilDelivery> typeFormatValidator() {
		return new OilDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilDelivery, Set<String>> onlyExistsValidator() {
		return new OilDeliveryOnlyExistsValidator();
	}
}
