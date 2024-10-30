package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OilTransferDelivery;
import fpml.confirmation.validation.OilTransferDeliveryTypeFormatValidator;
import fpml.confirmation.validation.OilTransferDeliveryValidator;
import fpml.confirmation.validation.exists.OilTransferDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OilTransferDelivery.class)
public class OilTransferDeliveryMeta implements RosettaMetaData<OilTransferDelivery> {

	@Override
	public List<Validator<? super OilTransferDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilTransferDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OilTransferDelivery> validator() {
		return new OilTransferDeliveryValidator();
	}

	@Override
	public Validator<? super OilTransferDelivery> typeFormatValidator() {
		return new OilTransferDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilTransferDelivery, Set<String>> onlyExistsValidator() {
		return new OilTransferDeliveryOnlyExistsValidator();
	}
}
