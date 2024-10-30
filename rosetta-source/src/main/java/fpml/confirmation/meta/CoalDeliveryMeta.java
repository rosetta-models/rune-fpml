package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalDelivery;
import fpml.confirmation.validation.CoalDeliveryTypeFormatValidator;
import fpml.confirmation.validation.CoalDeliveryValidator;
import fpml.confirmation.validation.exists.CoalDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalDelivery.class)
public class CoalDeliveryMeta implements RosettaMetaData<CoalDelivery> {

	@Override
	public List<Validator<? super CoalDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CoalDelivery>create(fpml.confirmation.validation.datarule.CoalDeliveryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalDelivery> validator() {
		return new CoalDeliveryValidator();
	}

	@Override
	public Validator<? super CoalDelivery> typeFormatValidator() {
		return new CoalDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalDelivery, Set<String>> onlyExistsValidator() {
		return new CoalDeliveryOnlyExistsValidator();
	}
}
